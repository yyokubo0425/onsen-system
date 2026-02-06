// 画面ロード表示

// Loading文字のウェーブ
const text = "Loading...";
const container = document.getElementById("loadingWave");
container.innerHTML = "";
text.split("").forEach((char) => {
  const span = document.createElement("span");
  span.textContent = char;
  container.appendChild(span);
});
const spans = container.querySelectorAll("span");
let index = 0;
function waveJump() {
  spans.forEach((s) => (s.style.transform = "translateY(0)"));
  spans[index].style.transform = "translateY(-18px)";
  index = (index + 1) % spans.length;
}
setInterval(waveJump, 120);

const loader = document.getElementById("loading-screen");

// 遅延ローダー用タイマー
let slowTimer = null;

// 遅延表示の基準時間（ms）
const DELAY = 150;

// ===============================
// ▼ 1. ページ読み込み（初回・リロード共通）
// ===============================
document.addEventListener("readystatechange", () => {
  // complete 以外（loading / interactive）のとき
  if (document.readyState !== "complete") {
    // 遅かったらローダーを出す
    slowTimer = setTimeout(() => {
      loader.style.display = "flex";
      loader.style.opacity = 1;
      loader.style.visibility = "visible";
    }, DELAY);
  }
});

// ===============================
// ▼ 2. ページ読み込み完了時
// ===============================
window.addEventListener("load", () => {
  // 150ms以内に読み終わったらローダーは出さない
  clearTimeout(slowTimer);

  // もしローダーが表示されている場合はフェードアウト
  loader.style.opacity = 0;

  setTimeout(() => {
    loader.style.display = "none";
    loader.style.visibility = "hidden";
  }, 300);
});

// ===============================
// ▼ 3. ページ遷移（リンク・フォーム送信・fetchリダイレクト全部）
// ===============================
window.addEventListener("beforeunload", () => {
  // 遅かったらローダーを出す
  slowTimer = setTimeout(() => {
    loader.style.display = "flex";
    loader.style.opacity = 1;
    loader.style.visibility = "visible";
  }, DELAY);
});
