function solution(genres, plays) {
  const genreMap = new Map();
  const songMap = new Map();
  const n = genres.length;

  for (let i = 0; i < n; i++) {
    const genre = genres[i];
    const play = plays[i];

    genreMap.set(genre, (genreMap.get(genre) || 0) + play);

    if (!songMap.has(genre)) songMap.set(genre, []);
    songMap.get(genre).push([play, i]);
  }

  const sortedGenres = Array.from(genreMap).sort((a, b) => b[1] - a[1]);

  const answer = [];

  for (const [genre] of sortedGenres) {
    const songs = songMap.get(genre);

    songs.sort((a, b) => b[0] - a[0] || a[1] - b[1]);

    for (let i = 0; i < Math.min(2, songs.length); i++) {
      answer.push(songs[i][1]);
    }
  }

  return answer;
}
