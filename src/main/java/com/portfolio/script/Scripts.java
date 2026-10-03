package com.portfolio.script;

/**
 * All JS lives here as a Java String, returned into a single <script> block.
 */
public class Scripts {

    public static String js() {
        return """
                function toggleNavMenu() {
                    var dropdown = document.getElementById('navDropdown');
                    dropdown.classList.toggle('open');
                }

                // Close the dropdown when clicking outside of it
                document.addEventListener('click', function (event) {
                    var dropdown = document.getElementById('navDropdown');
                    var menuBtn = document.getElementById('menuBtn');
                    if (!dropdown || !menuBtn) return;
                    if (!dropdown.contains(event.target) && !menuBtn.contains(event.target)) {
                        dropdown.classList.remove('open');
                    }
                });

                /* ---------- Hero text rotation ---------- */

                var heroWords = [
                    'Gireejesh Nilesh',
                    'Data Analyst',
                    'Business Analyst',
                    'Reporting Analyst',
                    'Data Associate',
                    'Data Scientist',
                    'Junior Data Engineer',
                    'SQL Developer',
                    'Power BI Developer',
                ];
                var heroIndex = 0;
                var HERO_INTERVAL_MS = 3000;
                var LETTER_STAGGER_IN_MS = 25;
                var LETTER_STAGGER_OUT_MS = 15;
                var TRANSITION_IN_MS = 450;
                var TRANSITION_OUT_MS = 300;

                function buildLetterSpans(container, text, animateIn) {
                    container.innerHTML = '';
                    var chars = Array.from(text);
                    chars.forEach(function (ch, i) {
                        var span = document.createElement('span');
                        span.className = 'letter';
                        span.textContent = ch === ' ' ? '\\u00A0' : ch;
                        span.style.transitionDelay = (i * LETTER_STAGGER_IN_MS) + 'ms';
                        container.appendChild(span);
                    });
                    if (animateIn) {
                        // Force a reflow so the browser registers the initial
                        // (hidden) state before we add "show", otherwise the
                        // transition would be skipped.
                        void container.offsetWidth;
                        requestAnimationFrame(function () {
                            container.querySelectorAll('.letter').forEach(function (span) {
                                span.classList.add('show');
                            });
                        });
                    }
                }

                function rotateHeroText() {
                    var container = document.getElementById('heroText');
                    if (!container) return;

                    var currentSpans = Array.prototype.slice.call(container.querySelectorAll('.letter'));
                    var total = currentSpans.length;

                    currentSpans.forEach(function (span, i) {
                        span.style.transitionDelay = (i * LETTER_STAGGER_OUT_MS) + 'ms';
                        span.classList.remove('show');
                        span.classList.add('hide');
                    });

                    var outDuration = total * LETTER_STAGGER_OUT_MS + TRANSITION_OUT_MS;

                    setTimeout(function () {
                        heroIndex = (heroIndex + 1) % heroWords.length;
                        buildLetterSpans(container, heroWords[heroIndex], true);
                    }, outDuration);
                }

                document.addEventListener('DOMContentLoaded', function () {
                    var container = document.getElementById('heroText');
                    if (!container) return;
                    // First word is already rendered server-side and visible;
                    // just kick off the recurring rotation.
                    setInterval(rotateHeroText, HERO_INTERVAL_MS);
                });

                /* ---------- Introduction video popup ---------- */

                function openIntroVideo() {
                    var overlay = document.getElementById('introVideoModal');
                    var video = document.getElementById('introVideoPlayer');
                    if (!overlay) return;
                    overlay.classList.add('open');
                    document.body.style.overflow = 'hidden';
                    if (video) {
                        video.currentTime = 0;
                        video.play().catch(function () {
                            // Autoplay can be blocked by the browser; the visible
                            // controls still let the user press play themselves.
                        });
                    }
                }

                function closeIntroVideo() {
                    var overlay = document.getElementById('introVideoModal');
                    var video = document.getElementById('introVideoPlayer');
                    if (!overlay) return;
                    overlay.classList.remove('open');
                    document.body.style.overflow = '';
                    if (video) {
                        video.pause();
                    }
                }

                function closeIntroVideoOnOverlay(event) {
                    if (event.target && event.target.id === 'introVideoModal') {
                        closeIntroVideo();
                    }
                }

                document.addEventListener('keydown', function (event) {
                    if (event.key === 'Escape') {
                        closeIntroVideo();
                    }
                });

                /* ---------- Projects accordion ---------- */

                function toggleAccordion(headerEl) {
                    var item = headerEl.parentElement;
                    var panel = item.querySelector('.accordion-panel');
                    var inner = panel.querySelector('.accordion-panel-inner');
                    var isOpen = item.classList.contains('open');

                    // Close any other open item first (one panel open at a time)
                    document.querySelectorAll('.accordion-item.open').forEach(function (openItem) {
                        if (openItem !== item) {
                            openItem.classList.remove('open');
                            openItem.querySelector('.accordion-panel').style.maxHeight = null;
                        }
                    });

                    if (isOpen) {
                        item.classList.remove('open');
                        panel.style.maxHeight = null;
                    } else {
                        item.classList.add('open');
                        panel.style.maxHeight = inner.scrollHeight + 'px';
                    }
                }

                // Keep an open panel's height correct if the window is resized
                // (e.g. rotating a phone, or resizing the browser).
                window.addEventListener('resize', function () {
                    var openItem = document.querySelector('.accordion-item.open');
                    if (!openItem) return;
                    var panel = openItem.querySelector('.accordion-panel');
                    var inner = panel.querySelector('.accordion-panel-inner');
                    panel.style.maxHeight = inner.scrollHeight + 'px';
                });
                """;
    }
}
