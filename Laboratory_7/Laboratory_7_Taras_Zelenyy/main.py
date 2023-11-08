# This module generates a jagged array representing the shaded areas of a square matrix.

def get_fill_symbol():
    """ Prompts the user for a single fill symbol and validates the input. """
    fill_symbol = input("Please enter a single symbol to fill the array: ")
    if len(fill_symbol) != 1:
        raise ValueError("You must enter exactly one symbol.")
    return fill_symbol


def generate_jagged_array(matrix_size, fill_symbol):
    """ Generates a jagged array based on the matrix size and fill symbol. """
    jagged_array = []
    for i in range(matrix_size):
        # Визначаємо кількість символів в кожному рядку
        if i < matrix_size // 2:
            row = [fill_symbol] * (i + 1)
        else:
            row = [fill_symbol] * (matrix_size - i)
        jagged_array.append(row)
    return jagged_array


def display_array(jagged_array):
    """ Displays the jagged array on the screen. """
    for row in jagged_array:
        print(row)


def main():
    try:
        matrix_size = int(input("Enter the size of the square matrix: "))
        if matrix_size < 1:
            raise ValueError("The size of the matrix must be at least 1.")
        fill_symbol = get_fill_symbol()
        jagged_array = generate_jagged_array(matrix_size, fill_symbol)
        display_array(jagged_array)
    except ValueError as e:
        print("Error:", e)


if __name__ == "__main__":
    main()
