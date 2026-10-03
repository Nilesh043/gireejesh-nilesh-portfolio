package com.portfolio.components;

/**
 * Navbar:
 *  - Left: original social icons (unchanged), now rendered with Remix Icons.
 *  - Middle: "Portfolio" text, same font/weight style the logo had.
 *  - Right: search icon removed, only the menu icon remains. Clicking it
 *    opens a dropdown with the essential portfolio nav links.
 */
public class Navbar {

    public String render() {
        return """
                <nav class="navbar">
                    <div class="navbar-icons">
                        <a href="https://www.linkedin.com/in/gireejesh-nilesh/" target="_blank" rel="noopener noreferrer">
                            <button class="icon-btn" title="LinkedIn"><i class="ri-linkedin-box-fill"></i></button>
                        </a>
                        <a href="https://github.com/Nilesh043" target="_blank" rel="noopener noreferrer">
                            <button class="icon-btn" title="GitHub"><i class="ri-github-line"></i></button>
                        </a>
                    </div>

                    <div class="logo">Portfolio</div>

                    <div class="navbar-right">
                        <button id="menuBtn" class="menu-btn" onclick="toggleNavMenu()" title="Menu">
                            <i class="ri-menu-line"></i>
                        </button>
                        <ul id="navDropdown" class="nav-dropdown">
                            <li><a href="/about">About</a></li>
                            <li><a href="/projects">Projects</a></li>
                            <li><a href="#studies">Studies</a></li>
                            <li><a href="#introduction" onclick="event.preventDefault(); openIntroVideo();">Introduction</a></li>
                            <li><a href="/certificates">Certificates</a></li>
                            <li><a href="https://mail.google.com/mail/?view=cm&amp;fs=1&amp;to=nileshshakhya88@gmail.com&amp;su=Interested%20in%20your%20profile" target="_blank" rel="noopener noreferrer">Hire me</a></li>
                            <li><a href="https://drive.google.com/file/d/1YcFc7ltTXICbdhTpnk-q3ARziPwj6yeE/view?usp=sharing" target="_blank" rel="noopener noreferrer">Resume</a></li>
                        </ul>
                    </div>
                </nav>
                """;
    }
}
