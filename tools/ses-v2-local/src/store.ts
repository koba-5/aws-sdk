import { Email } from "./types/Email";

const data: { emails: Array<Email> } = {
  emails: [],
};

export const saveEail = (email: Email) => {
  data.emails.push(email);
};

export const getStoreReadOnly = () => data;

export const cleanEmail = () => {
  data.emails = [];
};
