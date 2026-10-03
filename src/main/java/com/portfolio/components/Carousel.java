package com.portfolio.components;

import java.util.List;

/**
 * Infinite auto-scrolling carousel of nav-link cards.
 *
 * Two independent motions, as requested:
 *  - The whole track scrolls continuously right -> left, looping forever
 *    (achieved by duplicating the card list once and animating -50% translateX,
 *    so the seam between the two copies is invisible).
 *  - Inside each card, the image itself drifts left -> right on its own loop
 *    (an oversized image sliding within its frame), giving a subtle parallax
 *    feel independent of the track's motion.
 *
 * Each card is an <a>, matching the entries in the navbar dropdown:
 *  - About links to the real /about page.
 *  - Resume opens the Drive link in a new tab.
 *  - Introduction opens the video popup instead of navigating.
 *  - The rest still point at in-page anchors until their pages are built.
 */
public class Carousel {

    private record CardItem(String title, String imageUrl, String href, String target, String onClick) {
        CardItem(String title, String imageUrl, String href) {
            this(title, imageUrl, href, "", "");
        }
    }

    private static final String RESUME_DRIVE_LINK =
            "https://drive.google.com/file/d/1YcFc7ltTXICbdhTpnk-q3ARziPwj6yeE/view?usp=sharing";

    private static final String HIRE_ME_GMAIL_LINK =
            "https://mail.google.com/mail/?view=cm&amp;fs=1&amp;to=nileshshakhya88@gmail.com&amp;su=Interested%20in%20your%20profile";

    private static final List<CardItem> CARDS = List.of(
            new CardItem(
                    "About",
                    "https://imgs.search.brave.com/Jf3vNJWWWlGjVP5Qhl7J9eEcHrxJ_kSW116csmu-5so/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWcu/bWFnbmlmaWMuY29t/L3ByZW1pdW0tcGhv/dG8vYnVzaW5lc3Mt/d29tYW4tcG9ydHJh/aXQtc21pbGUtd2l0/aC12aXNpb24tcHJv/ZmVzc2lvbmFsLW1p/bmRzZXQtY29ycG9y/YXRlLWdvYWxzLXdp/dGgtc3VjY2Vzcy1m/YWNlLWhhcHB5LWNh/cmVlci1sZWFkZXJz/aGlwLW1pc3Npb24t/d2l0aC1lbXBvd2Vy/bWVudC1tb2NrdXAt/c3BhY2UtbGVhZGVy/LW1leGljb181OTA0/NjQtMTQwNjg4Lmpw/Zz9nYT1HQTEuMS4z/NzA5OTY4OC4xNzg3/NjM4NDI1JnNlbXQ9/YWlzX2h5YnJpZCZ3/PTc0MCZxPTgw",
                    "/about"),
            new CardItem(
                    "Resume",
                    "https://drive.google.com/file/d/1YcFc7ltTXICbdhTpnk-q3ARziPwj6yeE/view?usp=sharing",
                    RESUME_DRIVE_LINK,
                    "_blank",
                    ""),
            new CardItem(
                    "Projects",
                    "https://picsum.photos/seed/portfolio-projects/600/800",
                    "/projects"),
            new CardItem(
                    "Introduction",
                    "https://picsum.photos/seed/portfolio-intro/600/800",
                    "#introduction",
                    "",
                    "event.preventDefault(); openIntroVideo();"),
            new CardItem(
                    "Certifications and achievements",
                    "https://picsum.photos/seed/portfolio-certs/600/800",
                    "/certificates"),
            new CardItem(
                    "Hire me",
                    "https://picsum.photos/seed/portfolio-hireme/600/800",
                    HIRE_ME_GMAIL_LINK,
                    "_blank",
                    "")
    );

    public String render() {
        String cardsOnce = buildCardsHtml();
        // Duplicated so translateX(-50%) loops seamlessly with no visible jump/reset.
        String track = cardsOnce + cardsOnce;

        return """
                <section class="carousel-section">
                    <div class="carousel-viewport">
                        <div class="carousel-track">
                %s
                        </div>
                    </div>
                </section>
                """.formatted(track);
    }

    private String buildCardsHtml() {
        StringBuilder sb = new StringBuilder();
        for (CardItem card : CARDS) {
            StringBuilder attrs = new StringBuilder();
            attrs.append("href=\"").append(card.href()).append("\"");
            if (!card.target().isEmpty()) {
                attrs.append(" target=\"").append(card.target()).append("\" rel=\"noopener noreferrer\"");
            }
            if (!card.onClick().isEmpty()) {
                attrs.append(" onclick=\"").append(card.onClick()).append("\"");
            }

            sb.append("""
                            <a class="carousel-card" %s>
                                <div class="carousel-card-img-wrap">
                                    <img class="carousel-card-img" src="%s" alt="%s" loading="lazy" />
                                </div>
                                <div class="carousel-card-title">%s</div>
                            </a>
                    """.formatted(attrs, card.imageUrl(), card.title(), card.title()));
        }
        return sb.toString();
    }
}
