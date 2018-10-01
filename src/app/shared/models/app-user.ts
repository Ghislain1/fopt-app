export interface AppUser {

  // Ghislain: you can check how to model a user in firebase.User class or interface
  displayName: string | null;
  email: string | null;
  phoneNumber: string | null;
  photoURL: string | null;
  providerId: string;
  uid: string;

  //More from me
  isAdmin: boolean;
}
