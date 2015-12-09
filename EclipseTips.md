## 1. Show line numbers

Go to *Window* menu -> *Preferences* -> *General* -> *Editors* -> *Text Editors* -> *Show line numbers* -> *OK*.

![Show Line Numbers](https://raw.githubusercontent.com/MarcoXZh/OOPJavaCourse/master/Fig_ShowLineNumbers.png)


## 2. Show useful views

Go to *Window* menu -> *Show View*:

  - *Outline*: this view shows and helps quickly navigate to (by double-click) the attributes and methods in your
    current class.

    ![View: Outline](https://raw.githubusercontent.com/MarcoXZh/OOPJavaCourse/master/Fig_ViewOutline.gif)

  - *Console*: this view shows the console outputs, and accepts console inputs as well.

    ![View: Console](https://raw.githubusercontent.com/MarcoXZh/OOPJavaCourse/master/Fig_ViewConsole.gif)

  - *Tasks* (note this is not *Task List*): this view shows and helps quickly navigate to (by double-click) the TODO
    comments.

    ![View: Tasks](https://raw.githubusercontent.com/MarcoXZh/OOPJavaCourse/master/Fig_ViewTasks.gif)

By double-clicking the tab of a view, you can toggle to expand/collapse this view.

![View: Toggle](https://raw.githubusercontent.com/MarcoXZh/OOPJavaCourse/master/Fig_ViewToggle.gif)


## 3. Import/Export Eclipse projects

An Eclipse project (directory/archive file) contains the following 3 files at the root directory:

```text
.settings/org.eclipse.jdt.core.prefs
.classpath
.project
```

Note they are hidden in Unix/Linux.

To import it, go to *File* menu -> *Import...* -> *General* -> *Existing Projects into Workspace* -> *Next* -> *Select
root directory*/*Select archive files* -> *Browse...* -> *Finish*. If it is an archive file, the *Copy projects into
workspace* option is forced to be checked. If the project is already in your workspace, you have to uncheck this option
to click *Finish*.

To export an project, go to *File* menu -> *Export...* -> *General* -> *Archive File*/*File System* -> *next*. Choose
the project/files you want to export, type the file name/directory, and click *Finish*.
