function solve() {
    return (function () {
        let counter = 0;
        let reports = [];
        let resultElement;
        return {
            report: (author, description, reproducible, severity) => {
                let report = {
                    ID: counter++,
                    author: author,
                    description: description,
                    reproducible: reproducible,
                    severity: severity,
                    status: 'Open'
                };
                reports.push(report);
                if (typeof resultElement !== undefined) {
                    display(report, resultElement);
                }
            },
            setStatus: (id, newStatus) => {
                let report = reports.find(r => r.ID === id);

                report.status = newStatus;
                displayReports(reports, resultElement);
            },
            remove: (id) => {
                for (let index = 0; index < reports.length; index++) {
                    if (reports[index].ID === id) {
                        reports.splice(index, 1);
                    }
                }

                displayReports(reports, resultElement);
            },
            sort: (method) => {
                reports.sort((a, b) => {
                    if (a[method] < b[method]) {
                        return -1;
                    }
                    if (a[method] > b[method]) {
                        return 1;
                    }

                    return 0;
                });

                displayReports(reports, resultElement);
            },
            output: (selector) => {
                selector = selector.substring(1);
                resultElement = document.getElementById(selector);
                displayReports(reports, resultElement);
            }
        };
    })();

    function displayReports(reports, resultElement) {
        clearResultElement(resultElement);
        for (const report of reports) {
            display(report, resultElement);
        }
    }

    function display(report, resultElement) {
        const divReport = document.createElement('div');
        divReport.classList.add('report');
        divReport.id = `report_${report.ID}`;

        const divReportBody = document.createElement('div');
        divReportBody.classList.add('body');

        const pDescription = document.createElement('p');
        pDescription.textContent = `${report.description}`;
        divReportBody.appendChild(pDescription);
        divReport.appendChild(divReportBody);

        const divTitle = document.createElement('div');
        divTitle.classList.add('title');

        const authorSpan = document.createElement('span');
        authorSpan.classList.add('author');
        authorSpan.textContent = `Submitted by: ${report.author}`;
        divTitle.appendChild(authorSpan);

        const statusSpan = document.createElement('span');
        statusSpan.classList.add('status');
        statusSpan.textContent = `${report.status} | ${report.severity}`;
        divTitle.appendChild(statusSpan);

        divReport.appendChild(divTitle);

        resultElement.appendChild(divReport);
    }

    function clearResultElement(resultElement) {
        resultElement.textContent = '';
    }
}