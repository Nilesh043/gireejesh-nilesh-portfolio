package com.portfolio.components;

import java.util.List;

/**
 * Content for the Certifications & Achievements page. Reuses the same page
 * skeleton (.page-bg / .container) as Home/About/Projects via Layout.wrap.
 *
 * Renders a responsive grid of cards -- 4 per row on desktop, fewer as the
 * screen narrows -- one per certificate/achievement.
 */
public class Certificates {

    private record CertItem(String name, String issuedBy, String score, String dateIssued) {}

    private static final List<CertItem> CERTIFICATES = List.of(
            new CertItem(
                    "Google Data Analytics Professional Certificate",
                    "Google (via Coursera)",
                    "",
                    "2026"),
            new CertItem(
                    "Certificate of Virtual Internship - Data Analytics Process",
                    "AICTE",
                    "",
                    "2024"),
            new CertItem(
                    "Problem Solving (Basic) Certificate",
                    "HackerRank",
                    "",
                    "2025"),
                new CertItem(
                    "Certificate of Merit",
                    "Naukri Campus Young Turks",
                    "",
                    "2025")
    );

    public String render() {
        return """
                <div class="page-top-bar">
                    <a class="icon-btn back-btn" href="/" title="Back to Home">
                        <i class="ri-arrow-left-line"></i>
                    </a>
                    <h1 class="page-title">Certifications &amp; Achievements</h1>
                    <div class="page-top-bar-spacer"></div>
                </div>

                <div class="certs-grid">
                %s
                </div>
                """.formatted(buildCardsHtml());
    }

    private String buildCardsHtml() {
        StringBuilder sb = new StringBuilder();
        for (CertItem cert : CERTIFICATES) {
            String scoreHtml = cert.score().isEmpty()
                    ? ""
                    : "<div class=\"cert-score\">" + cert.score() + "</div>";

            sb.append("""
                            <div class="cert-card">
                                <div class="cert-icon"><i class="ri-award-line"></i></div>
                                <div class="cert-name">%s</div>
                                <div class="cert-issuer">Issued by %s</div>
                                %s
                                <div class="cert-date">%s</div>
                            </div>
                    """.formatted(cert.name(), cert.issuedBy(), scoreHtml, cert.dateIssued()));
        }
        return sb.toString();
    }
}
