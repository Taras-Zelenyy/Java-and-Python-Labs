import math
import pickle


def calculate_expression(x):
    """
    Обчислення виразу y = ctg(x) / sin(7x - 1).
    ctg(x) розраховується як 1/tan(x).
    """
    try:
        # Обчислення котангенса та синуса
        cotangent_x = 1 / math.tan(x)
        sine_7x_minus_1 = math.sin(7 * x - 1)

        # Обчислення виразу
        y = cotangent_x / sine_7x_minus_1
        return y
    except ZeroDivisionError:
        # Обробка помилки ділення на нуль
        print("Ділення на нуль в обчисленнях.")
        return None


def write_to_text_file(data, filename):
    """
    Запис даних у текстовий файл.
    """
    with open(filename, 'w') as file:
        file.write(str(data))


def read_from_text_file(filename):
    """
    Читання даних з текстового файлу.
    """
    with open(filename, 'r') as file:
        data = file.read()
    return data


def write_to_binary_file(data, filename):
    """
    Запис даних у двійковий файл за допомогою модуля pickle.
    """
    with open(filename, 'wb') as file:
        pickle.dump(data, file)


def read_from_binary_file(filename):
    """
    Читання даних з двійкового файлу за допомогою модуля pickle.
    """
    with open(filename, 'rb') as file:
        data = pickle.load(file)
    return data


def main():
    # Вхідне значення
    x = math.pi / 2  # Приклад значення для x

    # Обчислення виразу
    result = calculate_expression(x)
    print(f"Результат обчислення виразу: {result}")

    # Запис та читання у текстовий файл
    text_filename = 'result.txt'
    write_to_text_file(result, text_filename)
    print(f"Результат з текстового файлу: {read_from_text_file(text_filename)}")

    # Запис та читання у двійковий файл
    binary_filename = 'result.bin'
    write_to_binary_file(result, binary_filename)
    print(f"Результат з двійкового файлу: {read_from_binary_file(binary_filename)}")


if __name__ == "__main__":
    main()
