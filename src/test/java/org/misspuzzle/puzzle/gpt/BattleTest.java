package org.misspuzzle.puzzle.gpt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BattleTest {

    // ------------------------------------------------------------------
    // Helper to create a monster quickly
    // ------------------------------------------------------------------
    private Battle.Monster m(String name, double hp, double ap, Battle.Type type) {
        return new Battle.Monster(name, hp, ap, type);
    }

    // ------------------------------------------------------------------
    // Part 1 style – basic FIFO battle (no types matter)
    // ------------------------------------------------------------------
    @Test
    public void testBasicFIFOBattle() {
        Battle battle = new Battle();

        Battle.Team heroes = new Battle.Team("Heroes");
        heroes.monsters.add(m("Dragon", 100, 25, Battle.Type.FIRE));
        heroes.monsters.add(m("Griffin", 80, 20, Battle.Type.ELECTRIC));

        Battle.Team monsters = new Battle.Team("Monsters");
        monsters.monsters.add(m("Goblin", 30, 10, Battle.Type.GRASS));
        monsters.monsters.add(m("Orc", 50, 15, Battle.Type.WATER));
        monsters.monsters.add(m("Troll", 70, 12, Battle.Type.GRASS));

        List<String> log = battle.battleFIFO(heroes, monsters);

        assertFalse(log.isEmpty());
        assertTrue(log.get(0).contains("Battle begins: Heroes vs Monsters"));
        assertTrue(log.get(log.size() - 1).contains("wins!"));

        // Dragon should kill Goblin quickly
        assertTrue(log.stream().anyMatch(s -> s.contains("Goblin is eliminated!")));
    }

    // ------------------------------------------------------------------
    // Part 2 – Type effectiveness changes the outcome
    // ------------------------------------------------------------------
    @Test
    public void testTypeEffectiveness() {
        Battle battle = new Battle();

        // Water is strong against Fire
        Battle.Team waterTeam = new Battle.Team("WaterTeam");
        waterTeam.monsters.add(m("Squirtle", 50, 20, Battle.Type.WATER));

        Battle.Team fireTeam = new Battle.Team("FireTeam");
        fireTeam.monsters.add(m("Charmander", 40, 25, Battle.Type.FIRE));

        List<String> log = battle.battleFIFO(waterTeam, fireTeam);

        // Squirtle (Water) should do 2x damage → 40 damage → one-shot Charmander
        assertTrue(log.stream().anyMatch(s ->
                s.contains("Squirtle attacks Charmander") && s.contains("eliminated")));
        assertTrue(log.get(log.size() - 1).contains("WaterTeam wins!"));
    }

    // ------------------------------------------------------------------
    // Part 3 – Smart targeting chooses the best attacker
    // ------------------------------------------------------------------
    @Test
    public void testSmartTargetingChoosesBestAttacker() {
        Battle battle = new Battle();

        Battle.Team attackers = new Battle.Team("Attackers");
        attackers.monsters.add(m("FireMon", 100, 30, Battle.Type.FIRE));       // 30 * 0.5 = 15
        attackers.monsters.add(m("GrassMon", 100, 20, Battle.Type.GRASS));      // 20 * 2.0 = 40
        attackers.monsters.add(m("ElectricMon", 100, 25, Battle.Type.ELECTRIC)); // 25 * 2.0 = 50

        Battle.Team defenders = new Battle.Team("Defenders");
        defenders.monsters.add(m("WaterTank", 100, 10, Battle.Type.WATER));

        List<String> log = battle.battleMaxDamage(attackers, defenders);

        // ElectricMon does the most damage (50)
        assertTrue(log.get(1).contains("ElectricMon attacks WaterTank"));
        assertTrue(log.get(1).contains("50"));
    }

    // ------------------------------------------------------------------
    // Part 3 – Tie is broken by list order (first wins)
    // ------------------------------------------------------------------
    @Test
    public void testSmartTargetingTieBreakByOrder() {
        Battle battle = new Battle();

        Battle.Team attackers = new Battle.Team("Attackers");
        // Both do the same damage against the defender
        attackers.monsters.add(m("First", 100, 30, Battle.Type.FIRE));   // 30 * 1.0 = 30
        attackers.monsters.add(m("Second", 100, 30, Battle.Type.GRASS)); // 30 * 1.0 = 30

        Battle.Team defenders = new Battle.Team("Defenders");
        defenders.monsters.add(m("Neutral", 100, 10, Battle.Type.ELECTRIC));

        List<String> log = battle.battleMaxDamage(attackers, defenders);

        // On a tie the first monster in the list must be chosen
        assertTrue(log.get(1).contains("First attacks Neutral"));
    }

    // ------------------------------------------------------------------
    // Edge case – one team is empty
    // ------------------------------------------------------------------
    @Test
    public void testEmptyTeam() {
        Battle battle = new Battle();

        Battle.Team teamA = new Battle.Team("A");
        teamA.monsters.add(m("Hero", 50, 20, Battle.Type.FIRE));

        Battle.Team teamB = new Battle.Team("B"); // no monsters

        List<String> log = battle.battleFIFO(teamA, teamB);
        assertTrue(log.get(log.size() - 1).contains("A wins!"));
    }
}