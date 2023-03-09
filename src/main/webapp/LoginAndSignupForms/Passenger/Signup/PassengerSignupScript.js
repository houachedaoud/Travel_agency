const form = document.querySelector("form");
form.addEventListener("submit", function(event) {
  let valid = true;
  const inputs = form.querySelectorAll("input");
  inputs.forEach(function(input) {
    if (!input.value) {
      input.classList.add("error");
      valid = false;
    } else {
      input.classList.remove("error");
    }
  });
  if (!valid) {
    event.preventDefault();
  }
});