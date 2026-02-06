document.addEventListener("DOMContentLoaded", () => {
  const menuIcon = document.querySelector(".menu-icon");
  const sideMenu = document.getElementById("sideMenu");
  const menuOverlay = document.getElementById("menuOverlay");

  menuIcon.addEventListener("click", () => {
    sideMenu.classList.toggle("open");
    menuOverlay.classList.toggle("show");
  });

  menuOverlay.addEventListener("click", () => {
    sideMenu.classList.remove("open");
    menuOverlay.classList.remove("show");
  });
});