function solution(bandage, health, attacks) {
  let answer = 0;
  let prevTime = 0;
  let maximumHealth = health;
  const [castTime, healPerSecond, bonusHealing] = bandage;

  for (const [time, damage] of attacks) {
    const timeGap = time - prevTime - 1;
    prevTime = time;

    health += Math.floor(timeGap / castTime) * bonusHealing + Math.floor(timeGap * healPerSecond);
    health = health > maximumHealth ? maximumHealth : health;
    health -= damage;

    if (health <= 0) {
      health = -1;
      break;
    }
  }

  answer = health;

  return answer;
}
