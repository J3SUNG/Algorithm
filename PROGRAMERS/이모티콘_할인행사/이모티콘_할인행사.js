let ser = 0; //정답 가입
let mon = 0; //정답 가격
function dfs(users, emoticons, tmp, ind, val) {
  let sum; //사용자 A의 비용
  let tot = 0; //사용자들의 비용
  let con = 0; //사용자들의 가입 수
  if (ind == emoticons.length) {
    for (let i = 0; i < users.length; ++i) {
      sum = 0;
      for (let j = 0; j < tmp.length; ++j) {
        if (users[i][0] <= tmp[j]) {
          sum += emoticons[j] - (emoticons[j] / 100) * tmp[j];
        }
      }
      if (users[i][1] <= sum) {
        ++con;
      } else {
        tot += sum;
      }
    }
    if (ser < con) {
      ser = con;
      mon = tot;
    } else if (ser == con) {
      mon = Math.max(mon, tot);
    }
    return;
  }
  for (let i = 1; i <= 4; ++i) {
    tmp[ind] = i * 10;
    dfs(
      users,
      emoticons,
      tmp,
      ind + 1,
      val + emoticons[ind] - (emoticons[ind] / 100) * tmp[ind]
    );
  }
}

function solution(users, emoticons) {
  let answer = [];
  let dis = [];
  let tmp = [];
  dfs(users, emoticons, tmp, 0, 0);

  answer = [ser, mon];
  return answer;
}
