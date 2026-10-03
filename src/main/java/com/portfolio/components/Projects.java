package com.portfolio.components;

import java.util.List;

/**
 * Content for the Projects page. Reuses the same page skeleton (.page-bg /
 * .container) as Home/About via Layout.wrap.
 *
 * Renders a vertical accordion: each project title is a clickable header;
 * expanding it reveals a description plus whichever links were supplied
 * (LinkedIn post and Live demo are optional, GitHub is always shown).
 */
public class Projects {

    private record ProjectItem(
            String title,
            String description,
            String githubUrl,
            String linkedinUrl,
            String liveUrl
    ) {}

    private static final List<ProjectItem> PROJECTS = List.of(
                        new ProjectItem(
                    "OTT Subscription Churn & Revenue Analysis",
                                        "<p>Analyzed customer, subscription, and support data for a dummy OTT platform, "
                            + "pulling three normalized tables (customer, subscription, support) out of "
                            + "a SQLite database and joining them into a single analysis-ready dataset "
                            + "using Pandas.</p>"
                            + "<p><strong>Data cleaning:</strong> standardized inconsistent gender labels, "
                            + "fixed data types for date fields, backfilled missing country values by "
                            + "mapping each customer's state to a known country, and de-duplicated the "
                            + "support table (which had multiple complaint rows per customer) by keeping "
                            + "the latest complaint and rolling up a <code>complaint_count</code> per "
                            + "user before merging.</p>"
                            + "<p><strong>Feature engineering:</strong> derived a <code>churn_flag</code> "
                            + "from cancellation dates, computed <code>tenure_days</code> (days active, "
                            + "or days until cancellation for churned users), and bucketed each customer "
                            + "into a <code>churn_risk</code> tier (low/medium/high) from their churn "
                            + "score.</p>"
                            + "<p><strong>Key findings:</strong></p>"
                            + "<ul>"
                            + "<li>Overall churn rate of 28.6% (71.4% retention).</li>"
                            + "<li>Churn varies sharply by plan: Basic churns at 60%, vs. 22% for "
                            + "Standard and just 14% for Premium — cheaper plans are far stickier to "
                            + "lose.</li>"
                            + "<li>Acquisition channel matters even more: customers from referrals "
                            + "churned at 83%, versus 17% for paid and 0% for organic signups — a "
                            + "strong signal that referral-driven growth wasn't bringing in durable "
                            + "customers.</li>"
                            + "<li>Found a 0.77 correlation between support escalations and churn, "
                            + "with an escalation rate of 19% and an average of 0.43 complaints per "
                            + "customer — escalated support tickets are one of the clearest "
                            + "early-warning signs of churn in the data.</li>"
                            + "<li>Quantified revenue at risk from already-churned customers against "
                            + "an ARPU of ~₹18.85, and tracked monthly churn trends over time.</li>"
                            + "</ul>"
                            + "<p><strong>Visualization:</strong> built churn trend lines, bar charts "
                            + "by plan/state, a correlation heatmap (with careful ordinal encoding for "
                            + "plan type and churn risk, rather than naive categorical codes), a "
                            + "pairplot, and a multi-dimensional catplot breaking down monthly charges "
                            + "by plan, gender, and churn risk — plus summary pivot tables combining "
                            + "churn rate, revenue, and user counts by plan type.</p>",
                    "https://github.com/gireejesh/ott-churn-analysis",
                    "https://www.linkedin.com/posts/gireejesh-nilesh_ott-churn-analysis-activity-dummy",
                    ""),
            new ProjectItem(
                    "Hospital ER Operational Analytics Dashboard",
                                        "<p>Built an interactive Excel dashboard for a hospital ER department's monthly "
                            + "operations report, combining pivot tables with native Excel charts to "
                            + "turn raw visit logs into a single at-a-glance view for department "
                            + "leadership, filterable by year and month.</p>"
                            + "<p><strong>Dashboard design:</strong> a KPI card row surfacing total "
                            + "patient volume, average wait time, and patient satisfaction score; "
                            + "year (2023/2024) and Jan–Dec month selectors filtering the entire report; "
                            + "an admission-status breakdown table; a bar chart of patient volume by "
                            + "age bracket; a pie chart splitting visits into on-time vs. delayed; a "
                            + "donut chart for gender-wise patient split; and a chart tracking patient "
                            + "volume by department referral. All visuals are driven by pivot tables "
                            + "kept on separate sheets, keeping the raw data layer decoupled from the "
                            + "report view.</p>"
                            + "<p><strong>Key findings</strong> (from a sample monthly report):</p>"
                            + "<ul>"
                            + "<li>466 patients treated in the month, with an average wait time of "
                            + "35.1 minutes and a patient satisfaction score of 4.91 / 5.</li>"
                            + "<li>Admissions ran close to even: 51% of patients were admitted versus "
                            + "49% not admitted.</li>"
                            + "<li>Patient volume skews toward older age groups: the 60–74 bracket "
                            + "alone accounted for 76 visits — the single largest group — while every "
                            + "bracket under 60 stayed fairly close together (52–67 visits each).</li>"
                            + "<li>40% of patients were delayed beyond the target wait time, versus "
                            + "60% seen on time, with the patient base split almost evenly by gender "
                            + "(51% male, 49% female).</li>"
                            + "<li>Department referrals were heavily concentrated: the vast majority "
                            + "of visits (273) required no specialist referral, followed by General "
                            + "Practice (98) and Orthopedics (47), while departments like Cardiology, "
                            + "Neurology, and Renal each saw single digits to low double digits of "
                            + "referred patients.</li>"
                            + "</ul>"
                            + "<p><strong>Visualization:</strong> native Excel charts (bar, pie, donut, "
                            + "line) driven by SERIES formulas pointing at pivot tables, with "
                            + "year/month button grids acting as slicer-style filters across the whole "
                            + "dashboard.</p>",
                    "https://github.com/gireejesh/hospital-er-dashboard",
                    "https://www.linkedin.com/posts/gireejesh-nilesh_hospital-er-dashboard-activity-dummy",
                    "")      
    );

    public String render() {
        return """
                <div class="page-top-bar">
                    <a class="icon-btn back-btn" href="/" title="Back to Home">
                        <i class="ri-arrow-left-line"></i>
                    </a>
                    <h1 class="page-title">Projects</h1>
                    <div class="page-top-bar-spacer"></div>
                </div>

                <div class="projects-content">
                    <div class="accordion" id="projectsAccordion">
                %s
                    </div>
                </div>
                """.formatted(buildAccordionHtml());
    }

    private String buildAccordionHtml() {
        StringBuilder sb = new StringBuilder();
        for (ProjectItem project : PROJECTS) {
            sb.append("""
                            <div class="accordion-item">
                                <button class="accordion-header" onclick="toggleAccordion(this)">
                                    <span>%s</span>
                                    <i class="ri-arrow-down-s-line accordion-icon"></i>
                                </button>
                                <div class="accordion-panel">
                                    <div class="accordion-panel-inner">
                                        %s  
                                        <div class="accordion-links">
                    %s
                                        </div>
                                    </div>
                                </div>
                            </div>
                    """.formatted(project.title(), project.description(), buildLinksHtml(project)));
        }
        return sb.toString();
    }

    private String buildLinksHtml(ProjectItem project) {
        StringBuilder sb = new StringBuilder();

        if (!project.linkedinUrl().isEmpty()) {
            sb.append(linkHtml(project.linkedinUrl(), "ri-linkedin-box-line", "LinkedIn Post"));
        }

        // GitHub is always shown
        sb.append(linkHtml(project.githubUrl(), "ri-github-line", "GitHub"));

        if (!project.liveUrl().isEmpty()) {
            sb.append(linkHtml(project.liveUrl(), "ri-external-link-line", "Live Demo"));
        }

        return sb.toString();
    }

    private String linkHtml(String url, String iconClass, String label) {
        return """
                                            <a class="accordion-link" href="%s" target="_blank" rel="noopener noreferrer">
                                                <i class="%s"></i> %s
                                            </a>
                """.formatted(url, iconClass, label);
    }
}
