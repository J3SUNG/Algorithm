function solution(table, languages, preference) {
  let lan = [
    "JAVA",
    "JAVASCRIPT",
    "C",
    "C++",
    "C#",
    "SQL",
    "PYTHON",
    "KOTLIN",
    "PHP",
  ];
  let score = [0, 0, 0, 0, 0, 0, 0, 0, 0];
  let data_size;
  let prefer_field;
  let prefer_score = 0;
  let max_score = 0;
  let answer = "";
  languages.map((input_lan, index) => {
    for (let i = 0; i < 9; ++i) {
      if (input_lan === lan[i]) {
        score[i] = preference[index];
      }
    }
  });
  table.map((column) => {
    let data = column.split(" ");
    data_size = data.length;
    prefer_score = 0;
    for (let i = 1; i < data.length; ++i) {
      let j = lan.indexOf(data[i]);
      prefer_score += score[j] * (data_size - i);
    }
    if (max_score === prefer_score) {
      if (prefer_field > data[0]) {
        prefer_field = data[0];
      }
    }
    if (max_score < prefer_score) {
      prefer_field = data[0];
      max_score = prefer_score;
    }
  });
  answer = prefer_field;
  return answer;
}
