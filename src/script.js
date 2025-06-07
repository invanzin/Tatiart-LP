// Initialize Lucide icons
document.addEventListener("DOMContentLoaded", () => {
    // Check if lucide is defined before using it
    if (typeof lucide !== "undefined") {
      lucide.createIcons()
    } else {
      console.warn("Lucide is not defined. Ensure it is properly imported or included.")
    }
  })
  
  // Mobile menu toggle
  const mobileMenuBtn = document.getElementById("mobile-menu-btn")
  const mobileMenu = document.getElementById("mobile-menu")
  
  if (mobileMenuBtn && mobileMenu) {
    mobileMenuBtn.addEventListener("click", () => {
      mobileMenu.classList.toggle("active")
    })
  }
  
  // Smooth scrolling for anchor links
  document.querySelectorAll('a[href^="#"]').forEach((anchor) => {
    anchor.addEventListener("click", function (e) {
      e.preventDefault()
      const target = document.querySelector(this.getAttribute("href"))
      if (target) {
        target.scrollIntoView({
          behavior: "smooth",
          block: "start",
        })
        // Close mobile menu if open
        if (mobileMenu) {
          mobileMenu.classList.remove("active")
        }
      }
    })
  })
  
  // Add scroll effect to header
  window.addEventListener("scroll", () => {
    const header = document.querySelector("header")
    if (header) {
      if (window.scrollY > 100) {
        header.style.backgroundColor = "rgba(255, 252, 245, 0.98)"
      } else {
        header.style.backgroundColor = "rgba(255, 252, 245, 0.95)"
      }
    }
  })
  
  // Add hover effects to cards
  document.querySelectorAll(".hover-scale").forEach((element) => {
    element.addEventListener("mouseenter", () => {
      element.style.transform = "scale(1.05)"
    })
    element.addEventListener("mouseleave", () => {
      element.style.transform = "scale(1)"
    })
  })
  
  // Intersection Observer for animations
  const observerOptions = {
    threshold: 0.1,
    rootMargin: "0px 0px -50px 0px",
  }
  
  const observer = new IntersectionObserver((entries) => {
    entries.forEach((entry) => {
      if (entry.isIntersecting) {
        entry.target.classList.add("animate-in")
      }
    })
  }, observerOptions)
  
  // Observe elements for animation
  document.querySelectorAll(".testimonial-card, .gallery-item").forEach((el) => {
    observer.observe(el)
  })
  
  // Add click handlers for CTA buttons
  document.querySelectorAll("button").forEach((button) => {
    if (
      button.textContent.includes("Criar Minha Caneca") ||
      button.textContent.includes("Quero Minha Caneca") ||
      button.textContent.includes("Criar Minha Necessaire") ||
      button.textContent.includes("Quero Minha Necessaire") ||
      button.textContent.includes("Emocionar Alguém") ||
      button.textContent.includes("Família")
    ) {
      button.addEventListener("click", () => {
        // Simulate WhatsApp redirect
        const message = encodeURIComponent("Olá! Gostaria de criar um produto personalizado. Podem me ajudar?")
        const whatsappUrl = `https://wa.me/5511999999999?text=${message}`
        window.open(whatsappUrl, "_blank")
      })
    }
  })
  
  // Form validation and interaction
  function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
    return re.test(email)
  }
  
  // Add loading states to buttons
  function addLoadingState(button) {
    const originalText = button.textContent
    button.textContent = "Carregando..."
    button.disabled = true
  
    setTimeout(() => {
      button.textContent = originalText
      button.disabled = false
    }, 2000)
  }
  
  // Newsletter signup (if implemented)
  function handleNewsletterSignup(email) {
    if (validateEmail(email)) {
      console.log("Newsletter signup:", email)
      return true
    }
    return false
  }
  
  // Lazy loading for images
  if ("IntersectionObserver" in window) {
    const imageObserver = new IntersectionObserver((entries, observer) => {
      entries.forEach((entry) => {
        if (entry.isIntersecting) {
          const img = entry.target
          img.src = img.dataset.src || img.src
          img.classList.remove("lazy")
          imageObserver.unobserve(img)
        }
      })
    })
  
    document.querySelectorAll("img[data-src]").forEach((img) => {
      imageObserver.observe(img)
    })
  }
  
  // Analytics tracking (placeholder)
  function trackEvent(eventName, properties = {}) {
    console.log("Event tracked:", eventName, properties)
    // Here you would integrate with your analytics service
    // Example: gtag('event', eventName, properties);
  }
  
  // Track button clicks
  document.querySelectorAll("button").forEach((button) => {
    button.addEventListener("click", () => {
      trackEvent("button_click", {
        button_text: button.textContent.trim(),
        section: button.closest("section")?.id || "unknown",
      })
    })
  })
  
  // Performance monitoring
  window.addEventListener("load", () => {
    const loadTime = performance.now()
    console.log(`Page loaded in ${loadTime.toFixed(2)}ms`)
  
    // Track page load time
    trackEvent("page_load", {
      load_time: Math.round(loadTime),
    })
  })
  
  // Error handling
  window.addEventListener("error", (e) => {
    console.error("JavaScript error:", e.error)
    trackEvent("javascript_error", {
      message: e.message,
      filename: e.filename,
      line: e.lineno,
    })
  })
  