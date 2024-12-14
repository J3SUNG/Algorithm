const fs = require("fs");

const inputFile = process.argv[2];
const outputFile = process.argv[3];

if (!inputFile || !outputFile) {
  console.error("오류: 입력 파일 또는 출력 파일이 지정되지 않았습니다.");
  console.error("사용법: node Problem.js <입력 파일> <출력 파일>");
  process.exit(1);
}

const cleanText = (text) => {
  return text
    .toLowerCase()
    .replace(/[^a-z0-9]+/g, " ")
    .split(/\s+/);
};

const createInvertedFile = (lines) => {
  const invertedIndex = new Map();

  lines.forEach((line) => {
    const [docId, ...content] = line.trim().split(" ");
    const words = cleanText(content.join(" "));

    words.forEach((word) => {
      if (!word) return;

      if (!invertedIndex.has(word)) {
        invertedIndex.set(word, new Map());
      }

      const docMap = invertedIndex.get(word);
      const count = docMap.get(docId) || 0;
      docMap.set(docId, count + 1);
    });
  });

  return invertedIndex;
};

const writeInvertedFile = (invertedIndex, outputFile) => {
  const sortedWords = Array.from(invertedIndex.keys()).sort();
  const result = [];

  sortedWords.forEach((word) => {
    const docMap = invertedIndex.get(word);
    const sortedDocList = Array.from(docMap.entries()).sort((a, b) => {
      const [docIdA, countA] = a;
      const [docIdB, countB] = b;
      return countB - countA || docIdA - docIdB;
    });

    const line = [word, ...sortedDocList.flatMap(([docId, count]) => [docId, count])].join(" ");

    result.push(line);
  });

  fs.writeFileSync(outputFile, result.join("\n"), "utf8");
};

const main = () => {
  try {
    const input = fs.readFileSync(inputFile, "utf8");
    const lines = input.trim().split("\n");

    const invertedIndex = createInvertedFile(lines);

    writeInvertedFile(invertedIndex, outputFile);
  } catch (error) {
    console.error("파일을 처리하는 중 오류가 발생했습니다: ", error.message);
  }
};

main();
