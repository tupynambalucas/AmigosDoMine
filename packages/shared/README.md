# 🤝 Amigos Do Mine - Shared

**The Single Source of Truth.** 📜⚖️

This tiny package carries the weight of the world. It ensures that the **Backend** and **Frontend** are always on the same page. If a data structure exists, it is defined **here**.

## 📦 What's Inside?

1.  **Zod Schemas**: Robust validation rules. If it doesn't pass Zod, it doesn't get in. 🛡️
2.  **TypeScript Interfaces**: Inferred directly from Zod. No manual typing, no human error. 🤖
3.  **Constants**: Magic numbers and global strings live here.

## 🔄 The Workflow

Changes here ripple through the entire ecosystem.

1.  **Edit**: Change a schema in `src/schemas`.
2.  **Build**: Run `npm run build`.
3.  **Enjoy**: Your Frontend and Backend will immediately know about the update (or yell at you if you broke something).

## 🛠️ Commands

```bash
# Watch mode - perfect for active development
npm run dev

# Build - finalize the types
npm run build
```

> **Remember:** Never duplicate a type in Frontend or Backend. Import it from here! 👈
