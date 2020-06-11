"use strict";

function result() {
    class Keyboard {
        constructor(manufacturer, responseTime) {
            this.manufacturer = manufacturer;
            this.responseTime = responseTime;
        }
    }

    class Monitor {
        constructor(manufacturer, width, height) {
            this.manufacturer = manufacturer;
            this.width = width;
            this.height = height;
        }
    }

    class Battery {
        constructor(manufacturer, expectedLife) {
            this.manufacturer = manufacturer;
            this.expectedLife = expectedLife;
        }
    }

    class Computer {
        constructor(manufacturer, processorSpeed, ram, hardDiskSpace) {
            if (new.target === Computer) {
                throw new TypeError('Abstract class cannot be instantiated directly');
            }

            this.manufacturer = manufacturer;
            this.processorSpeed = processorSpeed;
            this.ram = ram;
            this.hardDiskSpace = hardDiskSpace;
        }
    }

    class Laptop extends Computer {
        constructor(manufacturer, processorSpeed, ram, hardDiskSpace, weight, color, battery) {
            super(manufacturer, processorSpeed, ram, hardDiskSpace);
            this.weight = weight;
            this.color = color;
            this.battery = battery;
        }

        get battery() {
            return this._battery;
        }

        set battery(battery) {
            if (battery.constructor.name === 'Battery') {
                this._battery = battery;
            } else {
                throw new TypeError();
            }
        }
    }

    class Desktop extends Computer {
        constructor(manufacturer, processorSpeed, ram, hardDiskSpace, keyboard, monitor) {
            super(manufacturer, processorSpeed, ram, hardDiskSpace);
            this.keyboard = keyboard;
            this.monitor = monitor;
        }

        get keyboard() {
            return this._keyboard;
        }

        set keyboard(keyboard) {
            if (keyboard.constructor.name === 'Keyboard') {
                this._keyboard = keyboard;
            } else {
                throw new TypeError();
            }
        }

        get monitor() {
            return this._monitor;
        }

        set monitor(monitor) {
            if (monitor.constructor.name === 'Monitor') {
                this._monitor = monitor;
            } else {
                throw new TypeError();
            }
        }
    }

    return {
        Battery,
        Keyboard,
        Monitor,
        Computer,
        Laptop,
        Desktop
    };
}

// let classes = createComputerHierarchy();
// let Computer = classes.Computer;
// let Laptop = classes.Laptop;
// let Desktop = classes.Desktop;
// let Monitor = classes.Monitor;
// let Battery = classes.Battery;
// let Keyboard = classes.Keyboard;

// let keyboard = new Keyboard('Logitech', 70);
// let monitor = new Monitor('Benq', 28, 18);
// let desktop = new Desktop("JAR Computers", 3.3, 8, 1, keyboard, monitor);

// console.log(desktop);

let classes = result();
let Computer = classes.Computer;
let Laptop = classes.Laptop;
let Desktop = classes.Desktop;
let Monitor = classes.Monitor;
let Battery = classes.Battery;
let Keyboard = classes.Keyboard;

let keyboard = new Keyboard('Logitech', 70);
let monitor = new Monitor('Benq', 28, 18);

// expect(()=>new Laptop("Hewlett Packard",2.4,4,0.5,3.12,"Silver","pesho")).to.throw(TypeError);
// expect(()=>new Desktop("JAR Computers",3.3,8,1,1,monitor)).to.throw(TypeError);
// expect(()=>new Desktop("JAR Computers",3.3,8,1,keyboard,"monitor")).to.throw(TypeError);

