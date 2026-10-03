# Portfolio (Pure Java / Servlet)

A Java-only web app. There are no standalone `.html`, `.css`, or `.js` files in
this project — the servlet builds the full page (markup, styles, script) as
Java Strings and writes it out as the HTTP response. It runs on an embedded
Jetty server, so no external Tomcat install is required.

## Requirements

- JDK 17+
- Maven 3.6+
- Internet access on first build (Maven needs to download Jetty)

## Run it

```bash
mvn compile exec:java
```

Then open **http://localhost:8080** in your browser.

## Project structure

```
src/main/java/com/portfolio/
├── Main.java                    # boots the embedded Jetty server, registers servlet routes
├── servlet/
│   ├── HomeServlet.java          # assembles the home page, handles GET /
│   ├── AboutServlet.java         # assembles the About page, handles GET /about
│   ├── ProjectsServlet.java      # assembles the Projects page, handles GET /projects
│   └── CertificatesServlet.java  # assembles the Certificates page, handles GET /certificates
├── components/
│   ├── Layout.java               # page skeleton (head, container, script/style hookup)
│   ├── Navbar.java               # navbar: social icons, "Portfolio" logo, menu dropdown
│   ├── Hero.java                 # rotating heading
│   ├── Carousel.java             # infinite scrolling nav-link cards
│   ├── About.java                # About page content
│   ├── Projects.java             # Projects page content (accordion)
│   ├── Certificates.java         # Certifications & Achievements page content (card grid)
│   └── IntroVideoModal.java      # video popup used by the Introduction link
├── style/
│   └── Styles.java               # all CSS, returned as a String
└── script/
    └── Scripts.java              # all JS, returned as a String
```
