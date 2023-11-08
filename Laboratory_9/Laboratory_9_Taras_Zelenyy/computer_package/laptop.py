from .computer import Computer


class Laptop(Computer):
    """Похідний клас для ноутбуків від базового класу Комп'ютер."""

    def __init__(self, brand, model, cpu, ram, storage, battery_life):
        super().__init__(brand, model, cpu, ram, storage)
        self._battery_life = battery_life
        self._battery_percentage = 100

    def get_battery_life(self):
        return self._battery_life

    def set_battery_life(self, hours):
        if hours > 0:
            self._battery_life = hours
        else:
            raise ValueError("Battery life must be greater than 0")

    def charge_battery(self):
        self._battery_percentage = 100
        print("Батарея повністю заряджена.")

    def show_battery_status(self):
        print(f"Заряд батареї: {self._battery_percentage}%")

    def use_battery(self):
        if self._battery_percentage > 0:
            self._battery_percentage -= 10  # Припустимо, що це використання за годину
            print(f"Використання батареї. Залишилось {self._battery_percentage}% заряду.")
        else:
            print("Батарея розряджена. Будь ласка, зарядіть батарею.")

    def specifications(self):
        base_specs = super().specifications()
        return f"{base_specs}\nТривалість роботи від батареї: {self._battery_life} годин"
