class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }
  isEmpty() {
    return this.size === 0;
  }
  add(data) {
    const newNode = new Node(data);

    if (this.isEmpty()) {
      this.head = newNode;
    } else {
      this.tail.next = newNode;
    }

    this.tail = newNode;
    ++this.size;
  }
  pop() {
    if (this.isEmpty()) {
      return null;
    }

    const popNode = this.head;
    this.head = this.head.next;

    if (!this.head) {
      this.tail = null;
    }

    --this.size;

    return popNode.data;
  }
  peek() {
    if (this.isEmpty()) {
      return null;
    }
    return this.head.data;
  }
}

function solution(relation) {
  let answer = 0;
  let bitArr = [];

  let q = new Queue();

  for (let i = 0; i < relation[0].length; ++i) {
    q.add([1 << i, i]);
  }

  while (!q.isEmpty()) {
    const data = q.pop();
    let chk = false;
    bitArr.map((bit) => {
      if ((data[0] & bit) === bit) {
        chk = true;
      }
    });

    if (chk) {
      continue;
    }

    let arr = [];
    relation.map((item) => {
      let str = "";
      for (let i = 0; i < item.length; ++i) {
        if ((data[0] & (1 << i)) !== 0) {
          str += item[i];
        }
      }
      arr.push(str);
    });
    if (checkUnique(arr)) {
      bitArr.push(data[0]);
      ++answer;
    } else {
      for (let i = data[1] + 1; i < relation[0].length; ++i) {
        q.add([data[0] | (1 << i), i]);
      }
    }
  }

  return answer;
}

function checkUnique(arr) {
  let set = new Set();

  arr.forEach((item) => {
    set.add(item);
  });

  if (arr.length === set.size) {
    return true;
  }

  return false;
}
