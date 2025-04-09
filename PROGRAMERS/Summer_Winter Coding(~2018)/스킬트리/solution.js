function solution(skill, skill_trees) {
  let answer = 0;

  for (const tree of skill_trees) {
    const filtered = [...tree].filter((c) => skill.includes(c)).join("");
    if (skill.startsWith(filtered)) {
      answer++;
    }
  }

  return answer;
}
