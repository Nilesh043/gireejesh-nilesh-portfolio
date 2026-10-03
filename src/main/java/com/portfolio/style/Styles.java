package com.portfolio.style;

/**
 * All CSS lives here as a Java String, returned into a single <style> block.
 * Kept in its own class (rather than inline in Layout) so it stays easy to
 * extend as we add each new section of the portfolio.
 */
public class Styles {

    public static String globalCss() {
        return """
                /* Smooth cross-fade between full page navigations (About <-> Home,
                   and future pages), supported natively by the browser -- no JS
                   framework/router needed. Browsers that don't support it yet
                   simply ignore this and navigate normally. */
                @view-transition {
                    navigation: auto;
                }

                * {
                    margin: 0;
                    padding: 0;
                    box-sizing: border-box;
                }

                body {
                    font-family: 'Poppins', sans-serif;
                    color: #16324f;
                    animation: pageFadeIn 0.45s ease;
                }

                @keyframes pageFadeIn {
                    from {
                        opacity: 0;
                    }
                    to {
                        opacity: 1;
                    }
                }

                .page-bg {
                    min-height: 100vh;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    background: #eef2f4;
                    padding: 40px 20px;
                }

                .container {
                    position: relative;
                    width: 100%;
                    max-width: 1100px;
                    background: #cfdde2;
                    border-radius: 40px;
                    padding: 30px 40px 60px;
                    min-height: 780px;
                }

                /* ---------- Navbar ---------- */

                .navbar {
                    display: flex;
                    align-items: center;
                    justify-content: space-between;
                }

                .navbar-icons {
                    display: flex;
                    gap: 10px;
                }

                .icon-btn {
                    width: 42px;
                    height: 42px;
                    border-radius: 50%;
                    background: #ffffff;
                    border: none;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    font-size: 18px;
                    color: #16324f;
                    cursor: pointer;
                    text-decoration: none;
                    transition: transform 0.15s ease;
                }

                .icon-btn:hover {
                    transform: translateY(-2px);
                }

                .logo {
                    font-size: 22px;
                    font-weight: 600;
                    letter-spacing: 0.5px;
                    color: #16324f;
                }

                .navbar-right {
                    position: relative;
                }

                .menu-btn {
                    width: 42px;
                    height: 42px;
                    border-radius: 50%;
                    background: #ffffff;
                    border: none;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    font-size: 20px;
                    color: #16324f;
                    cursor: pointer;
                }

                .nav-dropdown {
                    position: absolute;
                    top: 54px;
                    right: 0;
                    background: #ffffff;
                    border-radius: 18px;
                    box-shadow: 0 12px 30px rgba(22, 50, 79, 0.15);
                    padding: 10px;
                    min-width: 190px;
                    list-style: none;
                    opacity: 0;
                    transform: translateY(-8px);
                    pointer-events: none;
                    transition: all 0.18s ease;
                    z-index: 20;
                }

                .nav-dropdown.open {
                    opacity: 1;
                    transform: translateY(0);
                    pointer-events: auto;
                }

                .nav-dropdown li a {
                    display: block;
                    padding: 10px 14px;
                    border-radius: 10px;
                    color: #16324f;
                    text-decoration: none;
                    font-size: 14px;
                    font-weight: 500;
                }

                .nav-dropdown li a:hover {
                    background: #eef2f4;
                }

                /* ---------- Hero ---------- */

                .hero {
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    margin-top: 70px;
                    text-align: center;
                }

                .hero-text-wrap {
                    max-width: 900px;
                    margin: 0 auto;
                }

                .hero-title {
                    font-family: 'Poppins', sans-serif;
                    font-weight: 700;
                    font-size: clamp(2.1rem, 6.8vw, 5.2rem);
                    line-height: 1.08;
                    color: #16324f;
                    white-space: normal;
                    overflow-wrap: break-word;
                    min-height: 1.3em;
                }

                .letter {
                    display: inline-block;
                    opacity: 0;
                    transform: translateY(28px);
                    transition: opacity 0.45s ease, transform 0.45s ease;
                    will-change: transform, opacity;
                }

                .letter.show {
                    opacity: 1;
                    transform: translateY(0);
                }

                .letter.hide {
                    opacity: 0;
                    transform: translateY(-28px);
                    transition: opacity 0.3s ease, transform 0.3s ease;
                }

                /* ---------- Carousel ---------- */

                .carousel-section {
                    margin-top: 70px;
                    overflow: hidden;
                }

                .carousel-viewport {
                    overflow: hidden;
                    width: 100%;
                    -webkit-mask-image: linear-gradient(to right, transparent, black 6%, black 94%, transparent);
                    mask-image: linear-gradient(to right, transparent, black 6%, black 94%, transparent);
                }

                .carousel-track {
                    display: flex;
                    align-items: flex-start;
                    gap: 22px;
                    width: max-content;
                    animation: carouselScroll 30s linear infinite;
                }

                .carousel-track:hover {
                    animation-play-state: paused;
                }

                @keyframes carouselScroll {
                    from {
                        transform: translateX(0);
                    }
                    to {
                        transform: translateX(-50%);
                    }
                }

                .carousel-card {
                    flex: 0 0 auto;
                    width: 220px;
                    background: #ffffff;
                    border-radius: 24px;
                    padding: 12px;
                    display: flex;
                    flex-direction: column;
                    gap: 10px;
                    text-decoration: none;
                    color: #16324f;
                    box-shadow: 0 10px 24px rgba(22, 50, 79, 0.08);
                    transition: transform 0.25s ease, box-shadow 0.25s ease;
                }

                .carousel-card:hover {
                    transform: translateY(-6px);
                    box-shadow: 0 16px 30px rgba(22, 50, 79, 0.14);
                }

                .carousel-card-img-wrap {
                    width: 100%;
                    height: 260px;
                    border-radius: 18px;
                    overflow: hidden;
                    position: relative;
                    background: #dce6e9;
                }

                .carousel-card-img {
                    width: 130%;
                    max-width: 130%;
                    height: 100%;
                    object-fit: cover;
                    position: relative;
                    left: -15%;
                    animation: imgDrift 6s ease-in-out infinite alternate;
                }

                /* Slight variation per card so the drift feels organic, not lockstep */
                .carousel-card:nth-child(3n+1) .carousel-card-img {
                    animation-duration: 5s;
                }

                .carousel-card:nth-child(3n+2) .carousel-card-img {
                    animation-duration: 7s;
                    animation-delay: 0.4s;
                }

                .carousel-card:nth-child(3n) .carousel-card-img {
                    animation-duration: 6.2s;
                    animation-delay: 0.8s;
                }

                @keyframes imgDrift {
                    from {
                        transform: translateX(0);
                    }
                    to {
                        transform: translateX(15%);
                    }
                }

                .carousel-card-title {
                    font-weight: 600;
                    font-size: 15px;
                    padding: 0 4px 4px;
                }

                /* ---------- Inner pages (About, etc.) ---------- */

                .page-top-bar {
                    display: grid;
                    grid-template-columns: 1fr auto 1fr;
                    align-items: center;
                    margin-bottom: 40px;
                }

                .back-btn {
                    justify-self: start;
                }

                .page-title {
                    justify-self: center;
                    font-family: 'Poppins', sans-serif;
                    font-weight: 700;
                    font-size: clamp(1.8rem, 5vw, 3rem);
                    color: #16324f;
                }

                .page-top-bar-spacer {
                    justify-self: end;
                    width: 42px;
                    height: 42px;
                }

                .about-content {
                    max-width: 820px;
                    margin: 0 auto;
                }

                .about-intro {
                    display: flex;
                    gap: 30px;
                    align-items: center;
                    margin-bottom: 44px;
                }

                .about-photo {
                    width: 220px;
                    height: 220px;
                    object-fit: cover;
                    border-radius: 24px;
                    flex-shrink: 0;
                    box-shadow: 0 12px 26px rgba(22, 50, 79, 0.12);
                }

                .about-text p {
                    margin-bottom: 14px;
                    line-height: 1.7;
                    font-size: 15px;
                }

                .about-section-title {
                    font-size: 20px;
                    font-weight: 600;
                    margin: 30px 0 14px;
                }

                .about-list {
                    padding-left: 20px;
                }

                .about-list li {
                    margin-bottom: 10px;
                    line-height: 1.6;
                    font-size: 15px;
                }

                .about-list li::marker {
                    color: #16324f;
                }

                .about-banner-img {
                    width: 100%;
                    max-height: 260px;
                    object-fit: cover;
                    border-radius: 24px;
                    margin: 30px 0;
                    box-shadow: 0 12px 26px rgba(22, 50, 79, 0.1);
                }

                /* ---------- Projects (accordion) ---------- */

                .projects-content {
                    max-width: 820px;
                    margin: 0 auto;
                }

                .accordion {
                    display: flex;
                    flex-direction: column;
                    gap: 14px;
                }

                .accordion-item {
                    background: #ffffff;
                    border-radius: 20px;
                    overflow: hidden;
                    box-shadow: 0 8px 20px rgba(22, 50, 79, 0.06);
                }

                .accordion-header {
                    width: 100%;
                    display: flex;
                    align-items: center;
                    justify-content: space-between;
                    gap: 12px;
                    padding: 18px 22px;
                    background: none;
                    border: none;
                    cursor: pointer;
                    font-family: 'Poppins', sans-serif;
                    font-weight: 600;
                    font-size: 16px;
                    color: #16324f;
                    text-align: left;
                }

                .accordion-icon {
                    font-size: 20px;
                    flex-shrink: 0;
                    transition: transform 0.25s ease;
                }

                .accordion-item.open .accordion-icon {
                    transform: rotate(180deg);
                }

                .accordion-panel {
                    max-height: 0;
                    overflow: hidden;
                    transition: max-height 0.35s ease;
                }

                .accordion-panel-inner {
                    padding: 0 22px 22px;
                }

                .accordion-panel-inner p {
                    line-height: 1.7;
                    font-size: 14.5px;
                    color: #16324f;
                    margin-bottom: 16px;
                }
                                    .accordion-panel-inner strong {
                    font-weight: 600;
                }

                .accordion-panel-inner code {
                    background: #eef2f4;
                    padding: 2px 6px;
                    border-radius: 6px;
                    font-size: 13px;
                }

                .accordion-panel-inner ul {
                    padding-left: 20px;
                    margin-bottom: 16px;
                }

                .accordion-panel-inner ul li {
                    margin-bottom: 8px;
                    line-height: 1.6;
                    font-size: 14.5px;
                }

                .accordion-links {
                    display: flex;
                    flex-wrap: wrap;
                    gap: 10px;
                }

                .accordion-link {
                    display: inline-flex;
                    align-items: center;
                    gap: 6px;
                    padding: 8px 14px;
                    border-radius: 999px;
                    background: #eef2f4;
                    color: #16324f;
                    text-decoration: none;
                    font-size: 13px;
                    font-weight: 500;
                    transition: background 0.2s ease, transform 0.15s ease;
                }

                .accordion-link:hover {
                    background: #dce6e9;
                    transform: translateY(-2px);
                }

                .accordion-link i {
                    font-size: 15px;
                }

                /* ---------- Certifications & Achievements ---------- */

                .certs-grid {
                    display: grid;
                    grid-template-columns: repeat(4, 1fr);
                    gap: 18px;
                }

                .cert-card {
                    background: #ffffff;
                    border-radius: 20px;
                    padding: 22px 16px;
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    text-align: center;
                    gap: 6px;
                    box-shadow: 0 8px 20px rgba(22, 50, 79, 0.06);
                    transition: transform 0.2s ease, box-shadow 0.2s ease;
                }

                .cert-card:hover {
                    transform: translateY(-4px);
                    box-shadow: 0 14px 26px rgba(22, 50, 79, 0.12);
                }

                .cert-icon {
                    width: 52px;
                    height: 52px;
                    border-radius: 50%;
                    background: #eef2f4;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    font-size: 24px;
                    color: #16324f;
                    margin-bottom: 6px;
                }

                .cert-name {
                    font-weight: 600;
                    font-size: 14.5px;
                    color: #16324f;
                    line-height: 1.35;
                }

                .cert-issuer {
                    font-size: 12.5px;
                    color: #4d6a80;
                }

                .cert-score {
                    margin-top: 4px;
                    padding: 4px 10px;
                    border-radius: 999px;
                    background: #eef2f4;
                    font-size: 11.5px;
                    font-weight: 600;
                    color: #16324f;
                }

                .cert-date {
                    font-size: 11px;
                    color: #8096a8;
                    margin-top: 2px;
                }

                /* ---------- Introduction video popup ---------- */

                .video-modal-overlay {
                    position: fixed;
                    inset: 0;
                    background: rgba(22, 50, 79, 0.65);
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    padding: 20px;
                    z-index: 200;
                    opacity: 0;
                    pointer-events: none;
                    transition: opacity 0.25s ease;
                }

                .video-modal-overlay.open {
                    opacity: 1;
                    pointer-events: auto;
                }

                .video-modal-box {
                    position: relative;
                    width: 100%;
                    max-width: 720px;
                    background: #000;
                    border-radius: 20px;
                    overflow: hidden;
                    transform: scale(0.92);
                    transition: transform 0.25s ease;
                    box-shadow: 0 20px 50px rgba(0, 0, 0, 0.35);
                }

                .video-modal-overlay.open .video-modal-box {
                    transform: scale(1);
                }

                .video-modal-player {
                    width: 100%;
                    max-height: 70vh;
                    display: block;
                    background: #000;
                }

                .video-modal-close {
                    position: absolute;
                    top: 12px;
                    right: 12px;
                    width: 38px;
                    height: 38px;
                    border-radius: 50%;
                    background: rgba(255, 255, 255, 0.9);
                    border: none;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    font-size: 18px;
                    color: #16324f;
                    cursor: pointer;
                    z-index: 2;
                    transition: transform 0.15s ease;
                }

                .video-modal-close:hover {
                    transform: scale(1.08);
                }

                /* ---------- Responsive ---------- */

                @media (max-width: 900px) {
                    .container {
                        padding: 24px 26px 50px;
                        border-radius: 30px;
                    }

                    .hero {
                        margin-top: 50px;
                    }

                    .carousel-card {
                        width: 190px;
                    }

                    .carousel-card-img-wrap {
                        height: 230px;
                    }

                    .certs-grid {
                        grid-template-columns: repeat(2, 1fr);
                    }
                }

                @media (max-width: 640px) {
                    .logo {
                        font-size: 18px;
                    }

                    .icon-btn,
                    .menu-btn {
                        width: 36px;
                        height: 36px;
                        font-size: 16px;
                    }

                    .navbar-icons {
                        gap: 6px;
                    }

                    .hero {
                        flex-direction: column;
                        align-items: center;
                        gap: 16px;
                        margin-top: 36px;
                    }

                    .carousel-section {
                        margin-top: 44px;
                    }

                    .carousel-card {
                        width: 160px;
                        gap: 8px;
                        padding: 8px;
                    }

                    .carousel-card-img-wrap {
                        height: 190px;
                        border-radius: 14px;
                    }

                    .carousel-card-title {
                        font-size: 13px;
                    }

                    .carousel-track {
                        gap: 14px;
                        animation-duration: 22s;
                    }

                    .page-top-bar {
                        margin-bottom: 26px;
                    }

                    .about-intro {
                        flex-direction: column;
                        text-align: center;
                        gap: 18px;
                        margin-bottom: 32px;
                    }

                    .about-photo {
                        width: 160px;
                        height: 160px;
                    }

                    .video-modal-box {
                        max-width: 94vw;
                        border-radius: 14px;
                    }

                    .video-modal-player {
                        max-height: 50vh;
                    }

                    .accordion-header {
                        padding: 14px 16px;
                        font-size: 14px;
                    }

                    .accordion-panel-inner {
                        padding: 0 16px 16px;
                    }

                    .accordion-panel-inner p {
                        font-size: 13.5px;
                    }

                    .accordion-link {
                        font-size: 12px;
                        padding: 7px 12px;
                    }

                    .certs-grid {
                        grid-template-columns: 1fr;
                        gap: 14px;
                    }
                }

                @media (max-width: 400px) {
                    .container {
                        padding: 18px 16px 40px;
                        border-radius: 22px;
                    }
                }
                """;
    }
}
