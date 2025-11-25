class AudioPlayer:
    def __init__(self, file_name):
        self.file_name = file_name

    def record(self):
        print("Запис аудіо...")

    def save_recording(self):
        print("Запис збережено у файл.")

    def play(self):
        print("Відтворення аудіо...")

    def stop(self):
        print("Зупинення відтворення.")