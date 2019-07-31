#include <iostream>

using namespace std;

int main() {
    int examHour;
    int examMinute;
    int arrivalHour;
    int arrivalMinute;

    cin >> examHour >> examMinute >> arrivalHour >> arrivalMinute;

    examMinute = examMinute + examHour * 60;
    arrivalMinute = arrivalMinute + arrivalHour * 60;

    int minuteLeft = 0;
    int hourLeft = 0;

    if (examMinute >= arrivalMinute && (examMinute - arrivalMinute) <= 30) {
        cout << "On time" << endl;
    } else if ((examMinute - arrivalMinute) > 30) {
        cout << "Early" << endl;
    } else if ((examMinute - arrivalMinute) < 0) {
        cout << "Late" << endl;
    }

    if (examMinute > arrivalMinute && (examMinute - arrivalMinute) < 60) {
        cout << examMinute - arrivalMinute << " minutes before the start" << endl;
    } else if ((examMinute - arrivalMinute) >= 60) {
        hourLeft = (examMinute - arrivalMinute) / 60;
        minuteLeft = (examMinute - arrivalMinute) % 60;

        if (minuteLeft <= 9) {
            cout << hourLeft << ":0" << minuteLeft << " hours before the start" << endl;
        } else {
            cout << hourLeft << ":" << minuteLeft << " hours before the start" << endl;
        }
    }

    if (examMinute < arrivalMinute && (arrivalMinute - examMinute) < 60) {
        cout << arrivalMinute - examMinute << " minutes after the start" << endl;
    } else if ((arrivalMinute - examMinute) >= 60) {
        hourLeft = (arrivalMinute - examMinute) / 60;
        minuteLeft = (arrivalMinute - examMinute) % 60;

        if (minuteLeft <= 9) {
            cout << hourLeft << ":0" << minuteLeft << " hours after the start" << endl;
        } else {
            cout << hourLeft << ":" << minuteLeft << " hours after the start" << endl;
        }
    }

    return 0;
}