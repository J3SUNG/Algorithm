function solution(record) {
  let answer = [];
  let hashMap = new Map();

  record.map((item) => {
    let arr = item.split(" ");
    if (arr[0] === "Enter") {
      hashMap.set(arr[1], arr[2]);
    } else if (arr[0] === "Change") {
      hashMap.set(arr[1], arr[2]);
    }
  });

  record.map((item) => {
    let arr = item.split(" ");
    if (arr[0] === "Enter") {
      answer.push(hashMap.get(arr[1]) + "님이 들어왔습니다.");
    } else if (arr[0] === "Leave") {
      answer.push(hashMap.get(arr[1]) + "님이 나갔습니다.");
    }
  });

  return answer;
}
