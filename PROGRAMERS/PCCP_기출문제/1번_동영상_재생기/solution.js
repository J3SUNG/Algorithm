function solution(video_len, pos, op_start, op_end, commands) {
  const toSeconds = (time) => time.split(":").reduce((a, c) => a * 60 + +c);

  const totalSec = toSeconds(video_len);
  const opStartSec = toSeconds(op_start);
  const opEndSec = toSeconds(op_end);
  let posSec = toSeconds(pos);

  if (posSec >= opStartSec && posSec < opEndSec) {
    posSec = opEndSec;
  }

  commands.forEach((command) => {
    if (command === "next") {
      posSec = Math.min(posSec + 10, totalSec);
    } else if (command === "prev") {
      posSec = Math.max(posSec - 10, 0);
    }

    if (posSec >= opStartSec && posSec < opEndSec) {
      posSec = opEndSec;
    }
  });

  const minute = String(Math.floor(posSec / 60)).padStart(2, "0");
  const second = String(posSec % 60).padStart(2, "0");

  return `${minute}:${second}`;
}
