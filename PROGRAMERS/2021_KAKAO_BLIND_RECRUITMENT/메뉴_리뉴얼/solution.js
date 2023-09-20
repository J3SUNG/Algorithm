let answer = [];
let arr = [];
let courseSize = [];
function solution(orders, course) {
  orders.forEach((order) => {
    course.forEach((item, courseIndex) => {
      let bit = 0;

      for (let i = 0; i < order.length; ++i) {
        set(1, order, i, 1 << (order.charCodeAt(i) - 65), item, courseIndex);
      }
    });
  });

  course.forEach((item, courseIndex) => {
    for (let i = 0; i < 26; ++i) {
      func(1, i, 1 << i, String.fromCharCode(65 + i), item, courseIndex);
    }
  });

  answer.sort();

  return answer;
}

function set(size, order, index, bit, maxSize, courseIndex) {
  if (size === maxSize) {
    if (!arr[bit]) {
      arr[bit] = 1;
    } else {
      ++arr[bit];
    }

    if (!courseSize[courseIndex]) {
      courseSize[courseIndex] = 0;
    }
    courseSize[courseIndex] = Math.max(courseSize[courseIndex], arr[bit]);

    return;
  }
  for (let i = index + 1; i < order.length; ++i) {
    set(size + 1, order, i, bit | (1 << (order.charCodeAt(i) - 65)), maxSize, courseIndex);
  }
}

function func(size, index, bit, alp, maxSize, courseIndex) {
  if (size === maxSize) {
    if (arr[bit] > 1 && arr[bit] === courseSize[courseIndex]) {
      answer.push(alp);
    }

    return;
  }
  for (let i = index + 1; i < 26; ++i) {
    func(size + 1, i, bit | (1 << i), alp + String.fromCharCode(65 + i), maxSize, courseIndex);
  }
}
