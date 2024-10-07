function solution(commands) {
  let answer = [];
  let map = [];
  let parent = [];

  for (let i = 0; i <= 2550; ++i) {
    map[i] = "EMPTY";
    parent[i] = i;
  }

  commands.forEach((item) => {
    const arr = item.split(" ");

    if (arr[0] === "UPDATE") {
      if (arr.length === 3) {
        for (let i = 0; i <= 2550; ++i) {
          if (map[i] === arr[1]) {
            map[i] = arr[2];
          }
        }
      } else {
        let parentIndex = parent[calcNumber(arr[1], arr[2])];
        map[parentIndex] = arr[3];
      }
    } else if (arr[0] === "MERGE") {
      let parentIndex = parent[calcNumber(arr[1], arr[2])];
      let subParentIndex = parent[calcNumber(arr[3], arr[4])];

      if (map[parentIndex] === "EMPTY") {
        map[parentIndex] = map[subParentIndex];
      }

      for (let i = 1; i <= 2550; ++i) {
        if (parent[i] === subParentIndex) {
          parent[i] = parentIndex;
        }
      }
    } else if (arr[0] === "UNMERGE") {
      let parentIndex = parent[calcNumber(arr[1], arr[2])];
      map[calcNumber(arr[1], arr[2])] = map[parentIndex];

      for (let i = 1; i <= 2550; ++i) {
        if (parent[i] === parentIndex) {
          if (i !== calcNumber(arr[1], arr[2])) {
            map[i] = "EMPTY";
          }
          parent[i] = i;
        }
      }
    } else if (arr[0] === "PRINT") {
      let parentIndex = parent[calcNumber(arr[1], arr[2])];
      answer.push(map[parentIndex]);
    }
  });

  return answer;
}

function calcNumber(a, b) {
  return parseInt(a) * 50 + parseInt(b);
}
