class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

function insertNode(parent, node, xMap) {
  if (xMap[node.value] < xMap[parent.value]) {
    if (!parent.left) parent.left = node;
    else insertNode(parent.left, node, xMap);
  } else {
    if (!parent.right) parent.right = node;
    else insertNode(parent.right, node, xMap);
  }
}

function preorder(node, pre) {
  if (!node) return;
  pre.push(node.value);
  preorder(node.left, pre);
  preorder(node.right, pre);
}

function postorder(node, post) {
  if (!node) return;
  postorder(node.left, post);
  postorder(node.right, post);
  post.push(node.value);
}

function solution(nodeinfo) {
  let nodes = nodeinfo.map((item, idx) => [...item, idx + 1]);
  nodes.sort((a, b) => b[1] - a[1]);

  let xMap = {};
  nodes.forEach(([x, y, num]) => (xMap[num] = x));

  let root = new TreeNode(nodes[0][2]);

  for (let i = 1; i < nodes.length; i++) {
    let node = new TreeNode(nodes[i][2]);
    insertNode(root, node, xMap);
  }

  let pre = [];
  let post = [];

  preorder(root, pre);
  postorder(root, post);

  return [pre, post];
}
