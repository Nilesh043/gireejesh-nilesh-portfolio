package com.portfolio.components;

/**
 * Popup video player triggered by the "Introduction" nav link/card.
 * Hidden by default; Scripts.js toggles the ".open" class and controls
 * play/pause on the underlying <video> element.
 */
public class IntroVideoModal {

    private static final String VIDEO_URL =
            "https://cdn.dribbble.com/userupload/47174579/file/4aeb88d075d377c9373e22b05c604335.mp4";

    public String render() {
        return """
                <div id="introVideoModal" class="video-modal-overlay" onclick="closeIntroVideoOnOverlay(event)">
                    <div class="video-modal-box">
                        <button class="video-modal-close" onclick="closeIntroVideo()" title="Close">
                            <i class="ri-close-line"></i>
                        </button>
                        <video id="introVideoPlayer" class="video-modal-player" controls playsinline>
                            <source src="%s" type="video/mp4">
                            Your browser does not support the video tag.
                        </video>
                    </div>
                </div>
                """.formatted(VIDEO_URL);
    }
}
