function getRootNode(links) {
  const arr = new Array(links.length).fill(true);

  links.forEach(([a, b], index) => {
    if (a >= 0) {
      arr[a] = false;
    }
    if (b >= 0) {
      arr[b] = false;
    }
  });

  return arr.indexOf(true);
}

function getCuts(node, mid, num, links) {
  const n = num.length;
  const result = new Array(n);
  const stack = [];

  stack.push({ node: node, visited: false });

  while (stack.length > 0) {
    const top = stack[stack.length - 1];
    const current = top.node;

    if (!top.visited) {
      top.visited = true;
      if (links[current][0] !== -1) {
        stack.push({ node: links[current][0], visited: false });
      }
      if (links[current][1] !== -1) {
        stack.push({ node: links[current][1], visited: false });
      }
    } else {
      stack.pop();
      let sum = num[current];
      let groups = 0;
      const childrenResults = [];

      if (links[current][0] !== -1) {
        childrenResults.push(result[links[current][0]]);
        groups += result[links[current][0]][1];
      }
      if (links[current][1] !== -1) {
        childrenResults.push(result[links[current][1]]);
        groups += result[links[current][1]][1];
      }

      childrenResults.sort((a, b) => a[0] - b[0]);

      for (const [childSum] of childrenResults) {
        if (sum + childSum <= mid) {
          sum += childSum;
        } else {
          groups++;
        }
      }

      result[current] = [sum, groups];
    }
  }

  return result[node];
}

function solution(k, num, links) {
  const root = getRootNode(links);
  const totalSum = num.reduce((acc, cur) => acc + cur, 0);

  let low = Math.max(...num);
  let high = totalSum;
  let answer = high;

  while (low <= high) {
    const mid = Math.floor((low + high) / 2);
    const [_, cuts] = getCuts(root, mid, num, links);
    const groups = cuts + 1;

    if (groups <= k) {
      answer = mid;
      high = mid - 1;
    } else {
      low = mid + 1;
    }
  }

  return answer;
}
