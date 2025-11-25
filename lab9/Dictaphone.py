from AudioPlayer import AudioPlayer

class Dictaphone(AudioPlayer):
    def __init__(self, file_name):
        super().__init__(file_name)  # Викликаємо конструктор 

    def record(self):
        super().record()  
        print("Записуємо на диктофон...")

    def save_recording(self):
        super().save_recording()  
        print("Запис збережено у файл на диктофоні.")