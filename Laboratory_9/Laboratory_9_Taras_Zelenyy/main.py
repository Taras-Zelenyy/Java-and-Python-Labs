from computer_package.computer import Computer
from computer_package.laptop import Laptop


def main():
    # Створення об'єкта класу Комп'ютер
    computer = Computer('Lenovo', 'ThinkCentre', 'Intel i5', 16, 512)
    print("Комп'ютер:")
    computer.power_on()
    print(computer.specifications())
    computer.power_off()

    # Зміна конфігурації комп'ютера
    computer.set_ram(32)
    computer.set_storage(1024)
    print("Оновлені специфікації комп'ютера:")
    print(computer.specifications())

    # Створення об'єкта класу Ноутбук
    laptop = Laptop('Dell', 'XPS', 'Intel i7', 32, 1024, 10)
    print("\nНоутбук:")
    laptop.power_on()
    print(laptop.specifications())
    laptop.show_battery_status()
    laptop.use_battery()
    laptop.show_battery_status()
    laptop.charge_battery()
    laptop.show_battery_status()
    laptop.power_off()

    # Зміна параметрів ноутбука
    laptop.set_battery_life(12)
    print("Оновлені специфікації ноутбука:")
    print(laptop.specifications())


if __name__ == '__main__':
    main()
