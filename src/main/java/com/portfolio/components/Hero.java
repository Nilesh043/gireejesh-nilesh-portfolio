package com.portfolio.components;

/**
 * Hero section.
 * Replaces the "Creative Solutions" heading with a heading that cycles
 * through several titles/roles every 3 seconds, animating letter by letter.
 * The heading keeps the exact same font-family/weight/size treatment the
 * original "Creative Solutions" text used (see .hero-title in Styles.java) --
 * only the words rotate, not the styling.
 */
public class Hero {

    private static final String FIRST_WORD = "Gireejesh Nilesh";

    public String render() {
        return """
                <section class="hero">
                    <div class="hero-text-wrap">
                        <h1 id="heroText" class="hero-title">
                %s
                        </h1>
                    </div>
                </section>
                """.formatted(renderInitialLetters(FIRST_WORD));
    }

    /**
     * Renders the first word's letters already in their "shown" state
     * (server-side) so the page doesn't flash empty content before the
     * rotation script takes over on the client.
     */
    private String renderInitialLetters(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            String ch = (c == ' ') ? "&nbsp;" : String.valueOf(c);
            sb.append("<span class=\"letter show\">").append(ch).append("</span>");
        }
        return sb.toString();
    }
}
