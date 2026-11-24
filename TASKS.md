# How to generate new tasks

The lecture material lives in `dski-sources-3/<lecture>/`.
Read its `ABOUT.md` first: it decides what is relevant for the exam.

## Rules

- Only what `ABOUT.md` marks as relevant. No questions about slide details that
  neither the exercises nor the old exams ask for.
- Model the tasks on `origin-tasks/` and `origin-exams/`, at exam level, but with
  own scenarios and numbers, so the originals stay unused.
  Exception: questions the exam repeats word by word (e.g. BSDS) are copied as they are.
- Every task stands on its own: goal, names, values, file contents and code are
  inside the task. No references to other tasks or sheets.
- Ask for a whole result (one command, one file, one calculation, one model),
  not for fragments. Say how many parts or errors are expected.
- Check every intended solution before writing the task: run the command,
  validate the file, recalculate the numbers.
- Keep sheets short, about 30 tasks at most. No solutions in the sheets.

## Format

- One file per sheet: `tasks-original/<lecture>/NN-topic.md`. Task text in German.
- The answer goes on the line after `→` or into an empty code block.
- First sheet of a lecture is guided: topic, short explanation, one worked
  example, then one task. No tables to fill in.
- Later sheets: tasks first, a few understanding questions at the end.
- New tasks go into `tasks-original/`. `tasks/` is the learner's working copy
  created by `make` and may contain answers.
