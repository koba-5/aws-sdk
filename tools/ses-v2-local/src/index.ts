import express from "express";
import { getStoreHandler } from "./handlers/getStoreHandler";
import { cleanEmail } from "./store";
import { sendEmailV2Handler } from "./handlers/sendEmailV2Handler";

const app = express();

const PORT = 8005;

app.use(express.json({ limit: "25mb" }));
app.use(express.urlencoded({ extended: false, limit: "25mb" }));
app.use((req, _, next) => {
  console.log(`access ${req.method} ${req.url}`);
  next();
});

app.get("/", getStoreHandler);
app.post("/clean_email", cleanEmail);
app.post("/v2/email/outbound-emails", sendEmailV2Handler);

app.use((_, res) => {
  res.status(200).send({ cause: "NOT FOUND", message: "Page Not Found" });
});

app.listen(PORT, () => {
  console.log(`The server is running on port ${PORT}.`);
});
