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

## Built so far
- [x] Page skeleton (background, rounded container)
- [x] Navbar
  - Left: social icons (Telegram, Medium, GitHub, Reddit) via Remix Icon
  - Middle: "Portfolio" wordmark
  - Right: menu icon only (search removed) → opens a dropdown with
    About / Projects / Studies / Certificates / Contact / Resume
- [x] Hero
  - Heading rotates every 3s through: Gireejesh Nilesh / Developer Full Stack /
    Developer Frontend / Developer Backend / Developer Software
  - Animates letter by letter (staggered fade + slide), same font styling
    throughout — only the words change
  - Fully responsive font sizing (`clamp()`); now centered (arrow button removed)
- [x] Carousel
  - Infinite, seamless auto-scroll, whole track moving right → left
  - Each card's image independently drifts left → right inside its frame
    (subtle parallax, slightly different timing per card for an organic feel)
  - Cards double as nav links (About, Resume, Projects, Introduction,
    Certifications and achievements, Hire me) → same anchors as the navbar dropdown
  - Pauses on hover; fades out at the left/right edges; scales down on smaller screens
  - Resume opens the Drive link in a new tab; Introduction opens the video popup
    instead of navigating

## Pages
- `/` — Home (navbar, hero, carousel)
- `/about` — About page
  - Back-to-home icon button (top-left), "About" title centered at the top,
    reuses the exact same background/rounded-box UI as the home page
  - Dummy bio content: intro paragraphs, a couple of placeholder images,
    and bulleted sections ("What I do", "Tech I work with", "Beyond code")
  - The navbar dropdown's and carousel's "About" links now point to `/about`
    (Projects/Studies/Certificates/Contact still point at in-page anchors
    until their pages are built)
  - Navigations fade smoothly (native browser View Transitions where
    supported, with a plain CSS fade-in as a fallback everywhere else)
- `/projects` — Projects page
  - Same back-button + centered-title top bar, same background/box UI
  - A vertical accordion — one project per row, click a title to expand it
    (smooth height animation, one panel open at a time)
  - Each expanded panel shows a description plus whichever links exist:
    LinkedIn post (optional), GitHub (always shown), Live demo (optional)
  - 5 dummy projects included — edit the `PROJECTS` list in `Projects.java`
    to swap in your real ones and links
- `/certificates` — Certifications & Achievements page
  - Same top bar + background/box UI
  - Responsive card grid: 4 per row on desktop, 2 on tablet, 1 on mobile
  - Each card shows certificate name, issuer, score (only if provided), and date
  - 8 dummy certificates included — edit the `CERTIFICATES` list in
    `Certificates.java` to swap in your real ones

## Other nav link behavior
- **Resume** — opens the provided Google Drive link in a new tab
  (`target="_blank"`), from both the navbar dropdown and the carousel card.
  Update the link in `Navbar.java` and `Carousel.java` if it ever changes.
- **Introduction** — instead of navigating, opens a small popup (`IntroVideoModal.java`)
  that plays the provided video. Closes via the × button, clicking the dark
  overlay, or pressing Escape; the video pauses automatically when closed.
- **Hire me** (renamed from "Contact" in the dropdown) — opens a pre-composed
  Gmail draft in a new tab, To and Subject already filled in
  (`nileshshakhya88@gmail.com` / "Interested in your profile"), so the visitor
  just types a message and hits send. Update `HIRE_ME_GMAIL_LINK` in
  `Carousel.java` and the matching `<li>` in `Navbar.java` if the address changes.

## Next up
- Whatever section/page you'd like built next
