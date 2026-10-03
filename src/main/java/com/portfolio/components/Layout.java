package com.portfolio.components;

import com.portfolio.script.Scripts;
import com.portfolio.style.Styles;

/**
 * Basic page skeleton. Wraps whatever section HTML is passed in with the
 * full <html> document, the CDN links (Remix Icon + Google Font), the
 * generated <style> block, and the generated <script> block.
 *
 * Later sections (hero, projects, studies, certificates, contact, resume)
 * get added to the "body" content passed in from HomeServlet, part by part.
 */
public class Layout {

    public static String wrap(String title, String bodyContent) {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>%s</title>
                    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.9.0/fonts/remixicon.css" rel="stylesheet"/>
                    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet"/>
                    <style>
                %s
                    </style>
                </head>
                <body>
                    <div class="page-bg">
                        <div class="container">
                %s
                        </div>
                    </div>
                    <script>
                %s
                    </script>
                </body>
                </html>
                """.formatted(title, Styles.globalCss(), bodyContent, Scripts.js());
    }
}
