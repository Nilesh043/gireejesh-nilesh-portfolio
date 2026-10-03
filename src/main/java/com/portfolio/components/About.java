package com.portfolio.components;

/**
 * Content for the About page. Reuses the same page skeleton (.page-bg /
 * .container) as the home page via Layout.wrap, so the background color and
 * the rounded content box stay identical -- only what's inside changes.
 */
public class About {

    public String render() {
        return """
                <div class="page-top-bar">
                    <a class="icon-btn back-btn" href="/" title="Back to Home">
                        <i class="ri-arrow-left-line"></i>
                    </a>
                    <h1 class="page-title">About</h1>
                    <div class="page-top-bar-spacer"></div>
                </div>

                <div class="about-content">
                    <div class="about-intro">
                        <img class="about-photo"
                             src="https://picsum.photos/seed/portfolio-about-portrait/440/440"
                             alt="Portrait" />
                        <div class="about-text">
                            <p>
                                Hi, I'm Gireejesh, a data analyst who enjoys turning messy, real-world numbers into clean, decision-ready insights. My focus sits at the intersection of data and code: I like building things that don't just look good in a notebook, but actually hold up when real data and real stakeholders hit them.
                            </p>
                            <p>
                                I'm a B.Tech Graduate in Computer Science Engineering at Vignana Bharathi Institute of Technology, Hyderabad with a CGPA of 8.2. Over the last couple of years I've spent most of my time writing Python and SQL by day digging into churn patterns, operational bottlenecks, and whatever dataset needed making sense of and picking apart dashboards and web apps by night, which is roughly how this portfolio came to exist.
                            </p>
                        </div>
                    </div>

                    <img class="about-banner-img"
                         src="https://picsum.photos/seed/portfolio-about-workspace/1000/400"
                         alt="Workspace" />

                    <h2 class="about-section-title">What I do</h2>
                    <ul class="about-list">
                        <li>Clean and wrangle messy, real-world datasets into something trustworthy enough to build decisions on.</li>
                        <li>Build interactive dashboards (Power BI, Excel/DAX) that turn raw numbers into something a non-technical stakeholder can actually use.</li>
                        <li>Write Python and SQL to analyze trends, churn, and operational bottlenecks then, explain what they actually mean.</li>
                        <li>Visualize data clearly with Pandas, NumPy, Matplotlib, and Seaborn so the story in the numbers doesn't get lost.</li>
                        <li>Pick apart how web apps and tools work under the hood, for the fun of it, when I'm not analyzing data.</li>
                    </ul>

                    <h2 class="about-section-title">Tech I work with</h2>
                    <ul class="about-list">
                        <li>Languages: Python, SQL</li>
                        <li>Data analysis: Pandas, NumPy</li>
                        <li>Visualization: Matplotlib, Seaborn, Power BI</li>
                        <li>Spreadsheets: Excel (including DAX)</li>
                        <li>Tools: Jupyter Notebook, Git, VS Code</li>
                    </ul>

                    <h2 class="about-section-title">Beyond code</h2>
                    <p class="about-text">
                        Outside of analyzing data, I spend a fair amount of time reading about how businesses actually use data to make decisions, exploring new datasets just to see what stories they hold, and occasionally rebuilding an old analysis from scratch because I've picked up a cleaner way to do it since. This portfolio is, fittingly, one of those projects.
                    </p>
                </div>
                """;
    }
}
