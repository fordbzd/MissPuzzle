package org.misspuzzle.puzzle.gpt;

import java.util.*;

public class Battle {
    public enum Type {
        FIRE, WATER, GRASS, ELECTRIC
    }
    
    public static class Monster {
        String name;
        double hp;
        double ap;
        Type type;

        Monster(String name, double hp, double ap, Type type) {
            this.name = name;
            this.hp = hp;
            this.ap = ap;
            this.type = type;
        }

        public boolean isAlive() {
            return hp > 0;
        }

        public Event takeDamage(Monster attacker) {
            double damage = Math.min(attacker.ap * getTypeMultiplier(attacker.type), hp);
            hp -= damage;

            String message = attacker.name + " attacks " + name + " for " + damage + " damage. ";
            if (isAlive()) {
                message += name + " has " + hp + " HP remaining.";
            } else {
                message += name + " is eliminated!";
            }

            return new Event("Battle", message);
        }

        public double getTypeMultiplier(Type attackerType) {
            switch (attackerType) {
                case Type.FIRE:
                    switch (type) {
                        case Type.GRASS:
                            return 2.0;
                        case Type.WATER:
                            return 0.5;
                        default:
                            return 1.0;
                    }
                case Type.WATER:
                    switch (type) {
                        case Type.FIRE:
                            return 2.0;
                        case Type.GRASS:
                            return 0.5;
                        default:
                            return 1.0;
                    }
                case Type.GRASS:
                    switch (type) {
                        case Type.WATER:
                            return 2.0;
                        case Type.FIRE:
                            return 0.5;
                        default:
                            return 1.0;
                    }
                case Type.ELECTRIC:
                    switch (type) {
                        case Type.WATER:
                            return 2.0;
                        default:
                            return 1.0;
                    }
                default:
                    return 1.0;
            }
        }
    }

    public static class Team {
        String name;
        List<Monster> monsters;
        int curr;

        Team(String name) {
            this.name = name;
            monsters = new ArrayList<>();
            curr = 0;
        }

        public Monster getCurrentMonster() {
            return curr < monsters.size() ? monsters.get(curr) : null;
        }

        public Monster getMostDamageMonster(Monster defender) {
            Monster result = null;
            double max = 0;

            for (Monster monster : monsters) {
                if (monster.isAlive()) {
                    double damage = defender.getTypeMultiplier(monster.type) * monster.ap;
                    if (damage > max) {
                        result = monster;
                        max = damage;
                    }
                }
            }

            return result;
        }

        public Event defend(Monster attacker) {
            if (!isDefeated()) {
                Monster currMonster = getCurrentMonster();
                Event result = currMonster.takeDamage(attacker);

                if (!currMonster.isAlive()) {
                    curr++;
                }

                return result;
            }

            return null;
        }

        public boolean isDefeated() {
            return getCurrentMonster() == null;
        }
    }

    public static class Event {
            // Enum: Battle, Result
            String type;
            String message;

            Event(String type, String message) {
                this.type = type;
                this.message = message;
            }

            public String toString() {
                return type + ": " + message;
            }
        }

    public List<String> battleFIFO(Team teamA, Team teamB) {
        List<Event> events = new ArrayList<>();

        events.add(new Event("Battle begins", teamA.name + " vs " + teamB.name));

        if (teamB.monsters.size() == 0) {
            events.add(new Event("Battle ends", teamA.name + " wins!"));
        }

        Team attacker = teamA;
        Team defender = teamB;
        while (teamA.monsters.size() > 0 && teamB.monsters.size() > 0) {
            events.add(defender.defend(attacker.getCurrentMonster()));
            
            if (defender.isDefeated()) {
                events.add(new Event("Battle ends", attacker.name + " wins!"));
                break;
            }
            
            Team temp = attacker;
            attacker = defender;
            defender = temp;
        }

        return events.stream().map(k -> k.toString()).toList();
    }

    public List<String> battleMaxDamage(Team teamA, Team teamB) {
        List<Event> events = new ArrayList<>();

        events.add(new Event("Battle begins", teamA.name + " vs " + teamB.name));

        if (teamB.monsters.size() == 0) {
            events.add(new Event("Battle ends", teamA.name + " wins!"));
        }

        Team attacker = teamA;
        Team defender = teamB;
        while (teamA.monsters.size() > 0 && teamB.monsters.size() > 0) {
            events.add(defender.defend(attacker.getMostDamageMonster(defender.getCurrentMonster())));
            
            if (defender.isDefeated()) {
                events.add(new Event("Battle ends", attacker.name + " wins!"));
                break;
            }
            
            Team temp = attacker;
            attacker = defender;
            defender = temp;
        }

        return events.stream().map(k -> k.toString()).toList();
    }
}
