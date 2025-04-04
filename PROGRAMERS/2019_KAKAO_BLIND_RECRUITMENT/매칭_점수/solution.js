function solution(word, pages) {
  word = word.toLowerCase();
  const pageInfos = [];
  const urlToIndex = new Map();

  for (let i = 0; i < pages.length; i++) {
    const html = pages[i];
    const lowerHtml = html.toLowerCase();

    const metaTag = '<meta property="og:url" content="';
    const urlStart = html.indexOf(metaTag) + metaTag.length;
    const urlEnd = html.indexOf('"', urlStart);
    const url = html.substring(urlStart, urlEnd);
    urlToIndex.set(url, i);

    const links = [];
    let pos = 0;
    const linkTag = '<a href="';
    while (true) {
      const linkStart = html.indexOf(linkTag, pos);
      if (linkStart === -1) break;
      const linkUrlStart = linkStart + linkTag.length;
      const linkUrlEnd = html.indexOf('"', linkUrlStart);
      const link = html.substring(linkUrlStart, linkUrlEnd);
      links.push(link);
      pos = linkUrlEnd + 1;
    }

    const bodyStart = lowerHtml.indexOf("<body>");
    const bodyEnd = lowerHtml.indexOf("</body>");
    const bodyContent = html.substring(bodyStart + 6, bodyEnd).toLowerCase();

    const words = [];
    let currentWord = "";
    for (let ch of bodyContent) {
      if (ch >= "a" && ch <= "z") {
        currentWord += ch;
      } else {
        if (currentWord.length > 0) {
          words.push(currentWord);
          currentWord = "";
        }
      }
    }
    if (currentWord.length > 0) words.push(currentWord);

    const baseScore = words.filter((w) => w === word).length;

    pageInfos.push({
      index: i,
      url,
      links,
      baseScore,
      linkScore: 0,
    });
  }

  for (const page of pageInfos) {
    const shareScore = page.baseScore / page.links.length || 0;
    for (const link of page.links) {
      const targetIndex = urlToIndex.get(link);
      if (targetIndex !== undefined) {
        pageInfos[targetIndex].linkScore += shareScore;
      }
    }
  }

  let maxScore = -1;
  let answerIndex = -1;

  for (const page of pageInfos) {
    const totalScore = page.baseScore + page.linkScore;
    if (totalScore > maxScore || (totalScore === maxScore && page.index < answerIndex)) {
      maxScore = totalScore;
      answerIndex = page.index;
    }
  }

  return answerIndex;
}
