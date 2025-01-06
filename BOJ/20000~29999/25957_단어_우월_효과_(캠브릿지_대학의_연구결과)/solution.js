const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

readline
  .on("line", function (line) {
    input.push(line);
  })
  .on("close", function () {
    const map = new Map();

    const createKey = (str) => {
      return `${str[0]}|${str[str.length - 1]}|${str.length}|${str.split("").sort().join("")}`;
    };

    for (let i = 1; i <= Number(input[0]); ++i) {
      const key = createKey(input[i]);
      map.set(key, input[i]);
    }

    const arr = input[input.length - 1].split(" ");
    const result = arr.map((item) => map.get(createKey(item)));

    console.log(result.join(" "));

    process.exit();
  });
