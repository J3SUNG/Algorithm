function solution(players, callings) {
  const map = new Map(players.map((name, index) => [name, index]));

  callings.forEach((name) => {
    const currentRank = map.get(name);
    const previousRank = currentRank - 1;

    [players[currentRank], players[previousRank]] = [players[previousRank], players[currentRank]];

    map.set(players[currentRank], currentRank);
    map.set(players[previousRank], previousRank);
  });

  return players;
}
