class Computer:
    """Базовий клас для комп'ютерів."""

    def __init__(self, brand, model, cpu, ram, storage):
        self._brand = brand
        self._model = model
        self._cpu = cpu
        self._ram = ram
        self._storage = storage
        self._is_powered_on = False

    # Методи для отримання інформації (getters)
    def get_brand(self):
        return self._brand

    def get_model(self):
        return self._model

    def get_cpu(self):
        return self._cpu

    def get_ram(self):
        return self._ram

    def get_storage(self):
        return self._storage

    # Методи для встановлення інформації (setters)
    def set_brand(self, brand):
        self._brand = brand

    def set_model(self, model):
        self._model = model

    def set_cpu(self, cpu):
        self._cpu = cpu

    def set_ram(self, ram):
        if ram > 0:
            self._ram = ram
        else:
            raise ValueError("RAM must be greater than 0")

    def set_storage(self, storage):
        if storage > 0:
            self._storage = storage
        else:
            raise ValueError("Storage must be greater than 0")

    def power_on(self):
        self._is_powered_on = True
        print(f"{self._model} вмикання.")

    def power_off(self):
        self._is_powered_on = False
        print(f"{self._model} вимикання.")

    def is_powered_on(self):
        return self._is_powered_on

    def specifications(self):
        specs = (
            f"Бренд: {self._brand}",
            f"Модель: {self._model}",
            f"Процесор: {self._cpu}",
            f"Оперативна пам'ять: {self._ram} GB",
            f"Накопичувач: {self._storage} GB"
        )
        return "\n".join(specs)
