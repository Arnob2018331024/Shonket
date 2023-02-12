import os

def rename_files(directory):
    for filename in os.listdir(directory):
        new_filename = filename.replace("", "")
        os.rename(os.path.join(directory, filename), os.path.join(directory, new_filename))

# Example usage
#rename_files("./")
