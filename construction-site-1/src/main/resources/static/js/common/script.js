const navItems = document.getElementById("nav-list");
const navShut = document.getElementById("navbarSupportedContent");

navItems.addEventListener("click",()=>{
    navShut.classList.remove("show")
})


/*=============== SCROLL REVEAL ANIMATION ===============*/
const sr = ScrollReveal({
  origin: 'top',
  distance: '100px',
  duration: 2500,
  delay: 400,
  //reset: true
})

sr.reveal(`.carousel, .section-header, .service-data, .portfolio, .contact-container`)
sr.reveal(`.home__images`,{origin: 'bottom', delay:1000})
sr.reveal(`.carousel-caption, .about-img, .img-area, .form-left`,{origin: 'left'})
sr.reveal(`.about-text, .card-title, .map_main`,{origin: 'right'})
sr.reveal(`.lead .footer-data`,{interval:100})
