var menu = document.getElementsByClassName("sidebar")[0].getElementsByTagName("LI");
for (var i = 0; i < menu.length; i++) {
  var subMenuOpener = menu[i].getElementsByClassName("sub-menu-opener")[0];
  if(subMenuOpener) {
    subMenuOpener.addEventListener("click", function(e) {
      e.preventDefault();
      var submenu = this.nextElementSibling;
      var arrow = this.getElementsByClassName("arrow")[0];
      if (submenu) {
        submenu.classList.toggle("opened");
        arrow.classList.toggle("opened");
      }
    });
  }
}
